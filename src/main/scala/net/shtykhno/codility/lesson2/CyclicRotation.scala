package net.shtykhno.codility.lesson2

/**
A zero-indexed array A consisting of N integers is given.
Rotation of the array means that each element is shifted right by one index,
and the last element of the array is also moved to the first place.

For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7].
The goal is to rotate array A K times; that is, each element of A will be shifted to the right by K indexes.

Write a function:

object Solution { def solution(a: Array[Int], k: Int): Array[Int] }
that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment

100%
*/
object CyclicRotation extends App {

  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (a.isEmpty || a.length == 1 || k == 0) return a

    val k1 = k % a.length

    if (k1 < 1) return a

    a.slice(a.length - k1, a.length) ++ a.slice(0, a.length - k1)
  }

  assert(solution(Array(3, 8, 9, 7, 6), 2) sameElements Array(7, 6, 3, 8, 9))
}
