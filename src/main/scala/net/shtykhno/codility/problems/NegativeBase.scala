package net.shtykhno.codility.problems

/**
  * Write a function:

object Solution { def solution(a: Array[Int]): Array[Int] }

  that given a zero indexed array A of M bits containing a sequence representing
  some integer X returns the shortest sequence of bits representing -X

  For example :
  [1,0,0,1,1] (X = 9) result [1,1,0,1] (-9)
  [1,0,0,1,1,1] (X = -23) result [1,1,0,1,0,1,1] (23)
  */
object NegativeBase extends App {
  import scala.math.{pow, abs}
  import scala.collection.mutable

  /**
    *    4    3    2    1    0
    * (-2) (-2) (-2) (-2) (-2)
    *   1    1    0    0    1
    *   ---------------------
    *   16  -8   0    0    1  = 9
    */
  def toDecimal(x: Array[Int], radix: Int): Int = {
    x.indices.fold(0)((acc, i) => acc + x(i) * pow(radix, i).toInt)
  }

  def toBase(value: Int, radix: Int): Array[Int] = {
    val result = new mutable.ArrayBuffer[Int]

    var i = value
    while (i != 0) {
      var remainder = i % radix
      i /= radix

      if (remainder < 0) {
        remainder += abs(radix)
        i += 1
      }
      result += remainder
    }

    result.toArray
  }

  println(toDecimal(Array[Int](1,0,0,1,1), -2))
  println(toBase(9, -2).mkString(","))
  println(toBase(-9, -2).mkString(","))
  println(toBase(-23, -2).mkString(","))
  println(toBase(23, -2).mkString(","))
  // https://en.wikipedia.org/wiki/Negative_base
  println(toBase(146, -3).mkString(","))

}
