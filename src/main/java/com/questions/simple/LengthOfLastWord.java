/*
Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.



Example 1:

Input: s = "Hello World"
Output: 5
Example 2:

Input: s = " "
Output: 0


Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
*/
package com.questions.simple;

import java.util.Optional;
import java.util.function.Function;

public class LengthOfLastWord {
    private final String splitStr = " ";
    private Function<String, Integer> getLengthOfLastWord = (str) -> {
        if (str.trim().isEmpty())
            return 0;

        String[] splittedStr = str.split(splitStr);
        return splittedStr[splittedStr.length - 1].length();
    };

    public int lengthOfLastWord(String input) {
        return Optional.ofNullable(input).map(this.getLengthOfLastWord).orElse(0);
    }
}
