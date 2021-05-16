/*
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/
package com.questions.simple;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LongestSubstringWithoutRepeatingCharacters {
    String longestStr = "";
    public int lengthOfLongestSubstring(String input) {
        return this.longestSubstring.apply(input);
    }

    private Function<String, Integer> longestSubstring = (str) -> Optional.ofNullable(str).map(this.uniqueSubstrings).orElse(Stream.empty()).max(Comparator.comparingInt(String::length)).orElse("").length();

    private Function<String, Stream<String>> uniqueSubstrings = (str) -> {
        final List<String> strList = new ArrayList<>();
        str.chars().mapToObj(this.convertToString).forEach(indexStr -> {
            if(this.containsStringInLongestString.test(indexStr)){
                strList.add(longestStr);
                longestStr = indexStr;
                return;
            }
            longestStr = longestStr+indexStr;
        });
        return strList.stream();
    };

    private IntFunction<String> convertToString = num -> Character.toString((char)num);

    private Predicate<String> containsStringInLongestString =  (str) -> longestStr.contains(str);
}

//        String longestStr = "";
//        List<String> strList = new ArrayList<>();
//
//        for(int i=0; i<input.length(); i++){
//            String indexStr = Character.toString(input.charAt(i));
//            if(longestStr.contains(indexStr)){
//                strList.add(longestStr);
//                longestStr = indexStr;
//                continue;
//            }
//
//            longestStr = longestStr+indexStr;
//        }
//
//        return strList.stream().max(Comparator.comparingInt(String::length)).get().length();
//        Set<Character> charSet = new HashSet<>();
//        String  currentLongestString = "";
//        String  finalSubStr = "";
//        for(int i=0;i<input.length();i++){
//            Character c = input.charAt(i);
//            if(charSet.contains(c)){
//                currentLongestString = "";
//                charSet.clear();
//            }
//            charSet.add(c); //wk
//            currentLongestString = currentLongestString + c;
//
//            if(currentLongestString.length()>finalSubStr.length()){
//                finalSubStr =  currentLongestString;
//            }
//        }
//        return finalSubStr.length();