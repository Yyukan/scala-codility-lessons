package net.shtykhno.codility.lesson7

/**
A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

object Solution { def solution(s: String): Int }
that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Assume that:
N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".

Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).

100%
  */
object Nesting extends App {

  def solution(s: String): Int = {
    s match {
      case "" => 1
      case _ =>
        val result = s.foldLeft(0)((counter, character) => character match {
          case '(' => counter + 1
          case ')' => if (counter == 0) Int.MinValue else counter - 1
        })

        if (result == 0) 1 else 0
    }
  }

  assert(solution("") == 1)
  assert(solution("(()(())())") == 1)
  assert(solution("())") == 0)
}
