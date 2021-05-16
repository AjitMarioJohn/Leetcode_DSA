package com.questions.simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.IntStream;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String smallestString = this.smallestStringFromArray.apply(strs);
        return this.getLongestCommonPrefix.apply(strs, smallestString);
    }

    private BiFunction<String[], String, String> getLongestCommonPrefix = (strArr, smallestStr) -> Optional.ofNullable(strArr).map(arr -> {
        AtomicReference<String> prefix = new AtomicReference<>("");
        IntStream.range(0, smallestStr.length()).boxed().sorted(Collections.reverseOrder()).forEach( index -> {
            String substring = smallestStr.substring(0, index);
            AtomicBoolean contains = new AtomicBoolean(false);
            Arrays.stream(arr).forEach(str -> {
                contains.set(this.containsPrefix.test(substring, str));
            });
            if(contains.get()){
                prefix.set(substring);
                return;
            }
        });
        return Optional.ofNullable(prefix.get()).orElseGet(()->"");
    }).orElseGet(()->"");

    private Function<String[], String> smallestStringFromArray = (strArr) -> Optional.ofNullable(strArr).map(arr -> {
        AtomicReference<String> smallStr = new AtomicReference<>("");
        Arrays.stream(arr).forEach(str -> {
            smallStr.set(this.smallestString.apply(str, smallStr.get()));
        });
        return smallStr.get();
    }).orElseGet(()-> "");

    private BiFunction<String, String, String> smallestString = (str1, str2) -> {
        if(this.isSmallestString.test(str1,str2))
            return str1;

        return str2;
    };

    private BiPredicate<String, String> isSmallestString = (str1, str2) -> str1.length() < str2.length();

    private BiPredicate<String, String> containsPrefix = (str1, str2) -> str2.contains(str1);
}