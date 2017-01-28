package net.shtykhno.codility.lesson4

/**
Write a function:

object Solution { def solution(a: Array[Int]): Int }
that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0) that does not occur in A.

For example, given:

  A[0] = 1
  A[1] = 3
  A[2] = 6
  A[3] = 4
  A[4] = 1
  A[5] = 2
the function should return 5.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

100%
*/
object MissingInteger extends App {

  def solution(a: Array[Int]): Int = {
    a match {
      case Array() => 0
      case Array(1) => 2
      case Array(_) => 1
      case _ =>
        val set = a.filterNot(_ < 0).toSet
        var result = 1
        while(set.contains(result)) {
          result = result + 1
        }
        result
    }
  }

  println(solution(Array(1)))
  println(solution(Array(1, 3, 6, 7, 4, 1, 2)))
}
