/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Example 2:

Input: s = "IV"
Output: 4
Example 3:

Input: s = "IX"
Output: 9
Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/
package com.questions.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.IntStream;

public class RomanToInteger {

    private int lastNum = 0;

    public int romanToInt(String input) {
        return this.convertRomanToInt.apply(input);
    }

    private Function<String, Integer> convertRomanToInt = (romanStr) -> Optional.ofNullable(romanStr).map(this.convert).orElse(0);

    private Function<String, Integer> convert = (str) -> {
        if(this.isLengthValid.negate().test(str))
            return 0;
        return this.convertReverseStringToIntStream.apply(str).map(this.resultantNumber).sum();
    };

    private Function<String, IntStream> convertReverseStringToIntStream = (str) ->  this.reverseString.apply(str).chars();

    private Function<String, String> reverseString = (str) -> new StringBuffer(str).reverse().toString();

    private IntUnaryOperator resultantNumber = (value) -> {
        int lastCalcNum = this.lastNum;
        int resultantNum = Optional.ofNullable(this.romanToIntMapper.get().get(this.convertIntToString.apply(value))).orElse(0);
        this.lastNum = resultantNum;
        if(this.isLastDigitGreater.test(lastCalcNum,resultantNum)){
            return -resultantNum;
        }
        return resultantNum;
    };

    private IntFunction<String> convertIntToString = (value) -> Character.toString((char) value);

    private Supplier<Map<String, Integer>> romanToIntMapper = () -> {
        Map<String, Integer> mapper = new HashMap<>();
        mapper.put("I", 1);
        mapper.put("V", 5);
        mapper.put("X", 10);
        mapper.put("L", 50);
        mapper.put("C", 100);
        mapper.put("D", 500);
        mapper.put("M", 1000);

        return mapper;
    };

    BiPredicate<Integer, Integer> isLastDigitGreater = (lastNum, value) -> lastNum > value;

    Predicate<String> isLengthExceedFifteen = (str) -> this.isStringLengthExceedLimit.test(str,15);

    Predicate<String> isLengthValid = (str) -> this.isEmptyString.negate().and(this.isLengthExceedFifteen.negate()).test(str);

    Predicate<String> isEmptyString = (str) -> str.length() > 0;

    BiPredicate<String,Integer> isStringLengthExceedLimit = (str, permissibleLimit) -> str.length() > permissibleLimit;
}
