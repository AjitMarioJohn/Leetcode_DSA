package com.questions.simple;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LongestCommonPrefix {

    private final Predicate<String[]> isValidArray = (arr) -> arr.length > 1;
    private final BiPredicate<String, String> isItSelectedString = (selectedStr, str) -> selectedStr.equals(str);
    private String longestPrefix = "";
    private final Consumer<String> findLongestPrefix = (str) -> {
        while (str.indexOf(longestPrefix) != 0) {
            longestPrefix = longestPrefix.substring(0, longestPrefix.length() - 1);
        }
    };
private Function<String[], String> getStringAsPerArrLength = (strArr) -> strArr.length == 1 ? strArr[0] : longestPrefix;
        private Function<String[], String> checkLongestPrefix = (strArr) -> {
        if (this.isValidArray.negate().test(strArr)) {
            return this.getStringAsPerArrLength.apply(strArr);
        }

        longestPrefix = strArr[0];
        Arrays.stream(strArr).dropWhile(str -> this.isItSelectedString.test(longestPrefix, str))
                .forEach(this.findLongestPrefix);

        return longestPrefix;
    };;

    public String longestCommonPrefix(String[] strs) {
        return Optional.ofNullable(strs).map(this.checkLongestPrefix).orElse("");
    }
}