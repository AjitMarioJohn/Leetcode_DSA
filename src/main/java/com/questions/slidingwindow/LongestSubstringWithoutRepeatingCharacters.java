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
package com.questions.slidingwindow;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
    public int lengthOfLongestSubstring(String str, int k) {
        if (Objects.isNull(str) || str.trim().isEmpty()) {
            return 0;
        }
        int lengthOfLongestSubstring = Integer.MIN_VALUE;
        final Map<Character, Integer> letterTrack = new HashMap<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char letter = str.charAt(windowEnd);
            if (Objects.isNull(letterTrack.get(letter))) {
                letterTrack.put(letter, 1);
            }else if (Objects.nonNull(letterTrack.get(letter)) || ((windowEnd-windowStart) >= k)) {
                lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, str.substring (windowStart, (windowEnd)).length());
                windowStart = windowEnd;
            }
        }
        return lengthOfLongestSubstring;
    }
}