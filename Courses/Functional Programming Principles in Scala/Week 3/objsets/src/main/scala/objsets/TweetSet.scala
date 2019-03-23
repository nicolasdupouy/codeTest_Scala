package objsets

import common._
import TweetReader._

/**
 * A class to represent tweets.
 */
class Tweet(val user: String, val text: String, val retweets: Int) {
  override def toString: String =
    "User: " + user + "\n" +
      "Text: " + text + " [" + retweets + "]"
}

/**
 * This represents a set of objects of type `Tweet` in the form of a binary search
 * tree. Every branch in the tree has two children (two `TweetSet`s). There is an
 * invariant which always holds: for every branch `b`, all elements in the left
 * subtree are smaller than the tweet at `b`. The elements in the right subtree are
 * larger.
 *
 * Note that the above structure requires us to be able to compare two tweets (we
 * need to be able to say which of two tweets is larger, or if they are equal). In
 * this implementation, the equality / order of tweets is based on the tweet's text
 * (see `def incl`). Hence, a `TweetSet` could not contain two tweets with the same
 * text from different users.
 *
 *
 * The advantage of representing sets as binary search trees is that the elements
 * of the set can be found quickly. If you want to learn more you can take a look
 * at the Wikipedia page [1], but this is not necessary in order to solve this
 * assignment.
 *
 * [1] http://en.wikipedia.org/wiki/Binary_search_tree
 */
abstract class TweetSet {

  /**
   * This method takes a predicate and returns a subset of all the elements
   * in the original set for which the predicate is true.
   *
   * Question: Can we implement this method here, or should it remain abstract
   * and be implemented in the subclasses?
   */
  def filter(p: Tweet => Boolean): TweetSet = filterAcc(p, new Empty)

  /**
   * This is a helper method for `filter` that propagates the accumulated tweets.
   */
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet

  /**
   * Returns a new `TweetSet` that is the union of `TweetSet`s `this` and `that`.
   *
   * Question: Should we implment this method here, or should it remain abstract
   * and be implemented in the subclasses?
   */
  def union(that: TweetSet): TweetSet

  /**
   * Returns the tweet from this set which has the greatest retweet count.
   *
   * Calling `mostRetweeted` on an empty set should throw an exception of
   * type `java.util.NoSuchElementException`.
   *
   * Question: Should we implement this method here, or should it remain abstract
   * and be implemented in the subclasses?
   */
  def mostRetweeted: Tweet
  def mostRetweetedAcc(mostRetweetedtweet: Tweet): Tweet

  /**
   * Returns a list containing all tweets of this set, sorted by retweet count
   * in descending order. In other words, the head of the resulting list should
   * have the highest retweet count.
   *
   * Hint: the method `remove` on TweetSet will be very useful.
   * Question: Should we implement this method here, or should it remain abstract
   * and be implemented in the subclasses?
   */
  def descendingByRetweet: TweetList

  /**
   * The following methods are already implemented
   */

  /**
   * Returns a new `TweetSet` which contains all elements of this set, and the
   * the new element `tweet` in case it does not already exist in this set.
   *
   * If `this.contains(tweet)`, the current set is returned.
   */
  def incl(tweet: Tweet): TweetSet

  /**
   * Returns a new `TweetSet` which excludes `tweet`.
   */
  def remove(tweet: Tweet): TweetSet

  /**
   * Tests if `tweet` exists in this `TweetSet`.
   */
  def contains(tweet: Tweet): Boolean

  /**
   * This method takes a function and applies it to every element in the set.
   */
  def foreach(f: Tweet => Unit): Unit
}

class Empty extends TweetSet {

  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = acc

  def union(that: TweetSet): TweetSet = that

  def mostRetweeted: Tweet = throw new NoSuchElementException
  def mostRetweetedAcc(mostRetweetedtweet: Tweet): Tweet = mostRetweetedtweet

  def descendingByRetweet: TweetList = Nil

  /**
   * The following methods are already implemented
   */

  def contains(tweet: Tweet): Boolean = false

  def incl(tweet: Tweet): TweetSet = new NonEmpty(tweet, new Empty, new Empty)

  def remove(tweet: Tweet): TweetSet = this

  def foreach(f: Tweet => Unit): Unit = ()
}

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet {

  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = {
    val elemAcc = if (p(elem)) acc.incl(elem) else acc
    val leftAcc = left.filterAcc(p, elemAcc)
    right.filterAcc(p, leftAcc)

    /* V1
     if (p(elem)) left.filterAcc(p, right.filterAcc(p, acc incl elem))
     else left.filterAcc(p, right.filterAcc(p, acc))
     
     [Test Description] filter: tweet with 321 retweets
	 [Observed Error] Test timeout: aborted after 40 seconds; Check for infinite loops!
     */
  }

  def union(that: TweetSet): TweetSet = {
    filterAcc((t: Tweet) => !that.contains(t), that)

    /* V1
     ((left union right) union that) incl elem
     
     [Test Description] filter and union: tweets with 321 and 205 retweets
	 [Observed Error] Test timeout: aborted after 40 seconds; Check for infinite loops!
     */
  }

  def mostRetweeted: Tweet = mostRetweetedAcc(elem)

  def mostRetweetedAcc(mostRetweetedtweet: Tweet): Tweet =
    if (elem.retweets > mostRetweetedtweet.retweets) (left union right).mostRetweetedAcc(elem)
    else (left union right).mostRetweetedAcc(mostRetweetedtweet)

  def descendingByRetweet: TweetList = {
    val mostRetweetedtweet = mostRetweeted
    new Cons(mostRetweetedtweet, this.remove(mostRetweetedtweet).descendingByRetweet)
  }

  /**
   * The following methods are already implemented
   */

  def contains(x: Tweet): Boolean =
    if (x.text < elem.text) left.contains(x)
    else if (elem.text < x.text) right.contains(x)
    else true

  def incl(x: Tweet): TweetSet = {
    if (x.text < elem.text) new NonEmpty(elem, left.incl(x), right)
    else if (elem.text < x.text) new NonEmpty(elem, left, right.incl(x))
    else this
  }

  def remove(tw: Tweet): TweetSet =
    if (tw.text < elem.text) new NonEmpty(elem, left.remove(tw), right)
    else if (elem.text < tw.text) new NonEmpty(elem, left, right.remove(tw))
    else left.union(right)

  def foreach(f: Tweet => Unit): Unit = {
    f(elem)
    left.foreach(f)
    right.foreach(f)
  }
}

trait TweetList {
  def head: Tweet
  def tail: TweetList
  def isEmpty: Boolean
  def foreach(f: Tweet => Unit): Unit =
    if (!isEmpty) {
      f(head)
      tail.foreach(f)
    }
}

object Nil extends TweetList {
  def head = throw new java.util.NoSuchElementException("head of EmptyList")
  def tail = throw new java.util.NoSuchElementException("tail of EmptyList")
  def isEmpty = true
}

class Cons(val head: Tweet, val tail: TweetList) extends TweetList {
  def isEmpty = false
}

object GoogleVsApple {
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

  def filterTweet(word: String, ts: TweetSet): TweetSet =
    ts.filter(t => t.text.contains(word))

  def filterTweets(words: List[String], ts: TweetSet) =
    ts.filter(t => words.exists(w => t.text.contains(w)))

  lazy val googleTweets: TweetSet = filterTweets(google, TweetReader.allTweets) //filterTweet("android", TweetReader.allTweets)
  lazy val appleTweets: TweetSet = filterTweets(google, TweetReader.allTweets)

  /**
   * A list of all tweets mentioning a keyword from either apple or google,
   * sorted by the number of retweets.
   */
  lazy val trending: TweetList = (googleTweets union appleTweets).descendingByRetweet
}

object Main extends App {
  def timeIt[T](f: => T): (T, Double) = {
    val startTime = System.nanoTime()
    val result = f
    val stopTime = System.nanoTime()
    (result, (stopTime - startTime) / 1000000000.0d)
  }

  val (tweetSets, tweetSetsTime) = timeIt(TweetReader.tweetSets)
  println(s"create tweetSets(their incl): $tweetSetsTime")

  val (allTweets, allTweetsTime) = timeIt(TweetReader.allTweets)
  println(s"create allTweets(our union): $allTweetsTime")

  val (trending, trendingTime) = timeIt(GoogleVsApple.trending)
  println(s"create trending(our union and descending): $trendingTime")
  // Print the trending tweets
  //trending foreach println

  // Print the trending tweets
  GoogleVsApple.trending foreach println
}
