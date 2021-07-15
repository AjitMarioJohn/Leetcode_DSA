/*
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.



Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.


Constraints:

0 <= x <= 231 - 1
*/
package com.questions.simple;

public class SquareRoot {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;

        int start = 0, end = x / 2, ans = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            int square = middle * middle;

            if (square == x)
                return middle;

            if (square < x) {
                start = middle + 1;
                ans = middle;
                continue;
            }

            end = middle - 1;
        }
        return ans;
    }
}
