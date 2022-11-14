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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * So, the prerequisit of this problem is Sliding Window, if you know then it's a plus point. But, if you don't know don't worry I'll try to teach you.
 *
 * Let's understand first of all what the problem is saying!!
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 * Okay, so from the given statement we will try to find out wether it is a Sliding Window problem or not>>
 *
 * So, to check that out I'm giving you a tempelate & it'll work in almost all of the questions of sliding window
 *
 * To, find out a sliding window problem :-
 * > First thing is, we have given something like an "Array" | OR | "String"
 * > Second thing is, they are talking about either "subsequence" | OR | "substring"
 * > And third most thing is, either we have given a "window size i.e. k" | OR | we have to "manually find out window size"
 * Now, using above keys let's understand wether this problem is of a sliding window or not.
 *
 * > Are they talking about, "Array" or "String" --> yes they are talking about "string" +1 point
 * > Are they asking to find out "subsequence" or "substring" --> yes they are talking about "substring" +1 point
 * > Do, we have given a window size --> No, we don't have
 *
 * Total score is "2 / 3" so, it's a 100% sliding window problem. If your score lies from 2/3 to 3/3 that's a gauranteed sliding window problem
 * Now, let's talk about how we gonna implement sliding window in this problem, but before that I just want to tell you one more thing. There's exist basically 2 types of sliding window.
 *
 * Fix size sliding window {means K is given}
 *
 * Variable silze sliding window {means K is not given}
 *
 * Before moving to the problem I want to give you a template which you can use in any sliding window {Variable size} problem
 *
 * while(j < size()){
 *
 *     // Calculation's happen's here
 * -----------------------------------------------
 *     if(condition < k){
 *         j++;
 *     }
 * -----------------------------------------------
 *
 * -----------------------------------------------
 *     else if(condition == k){
 *         // ans <-- calculation
 *         j++;
 *     }
 * ----------------------------------------------
 *
 * ----------------------------------------------
 *     else if(condition > k){
 *         while(condition > k){
 *             // remove calculation for i
 *             i++;
 *         }
 *         j++;
 *     }
 * ----------------------------------------------
 * }
 * return ans;
 * So, in this problem we gonna deal with variable size sliding window. Let's take one example :-
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * So, inorder to solve this, what I'm thinking is, we should have to use one more Data Structure to store the occurence of these characters, I thing HashMap will be best to use.
 *
 * Now, what I'll do is create 2 pointer's i & j initally they both start from 0
 * The j pointer will helps us to fill the array while the i pointer will helps in removing from the map {Don't know what I'm talking about} just wait. You'll understand :)
 * Let's understand it visually :-
 *
 * https://youtu.be/XZIzesGjV68
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String str) {
        return Optional.ofNullable(str).map(s -> {
            Map<Character, Integer> map = new HashMap<>();
            int i = 0;
            int j = 0;
            int max = 0;
            while(j < s.length()){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if(map.size() == j - i + 1){
                    max = Math.max(max, j - i + 1);
                    j++;
                }
                else if(map.size() < j - i + 1){
                    while(map.size() < j - i + 1){
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                        if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                        i++;
                    }
                    j++;
                }
            }
            return max;
        }).orElse(0);
    }
}
//public class LongestSubstringWithoutRepeatingCharacters {
//    String longestStr = "";
//    public int lengthOfLongestSubstring(String input) {
//        return this.longestSubstring.apply(input);
//    }
//
//    private Function<String, Integer> longestSubstring = (str) -> Optional.ofNullable(str).map(this.uniqueSubstrings).orElse(Stream.empty()).max(Comparator.comparingInt(String::length)).orElse("").length();
//
//    private Function<String, Stream<String>> uniqueSubstrings = (str) -> {
//        final List<String> strList = new ArrayList<>();
//        str.chars().mapToObj(this.convertToString).forEach(indexStr -> {
//            if(this.containsStringInLongestString.test(indexStr)){
//                strList.add(longestStr);
//                longestStr = indexStr;
//                return;
//            }
//            longestStr = longestStr+indexStr;
//        });
//        return strList.stream();
//    };
//
//    private IntFunction<String> convertToString = num -> Character.toString((char)num);
//
//    private Predicate<String> containsStringInLongestString =  (str) -> longestStr.contains(str);
//}

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