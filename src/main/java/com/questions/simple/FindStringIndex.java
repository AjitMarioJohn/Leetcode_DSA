package com.questions.simple;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class FindStringIndex {
    private final BiFunction<String, String, Integer> findIndexOf = (haystack, needle) -> Optional.ofNullable(needle)
            .map(searchStr -> this.findIndex.apply(haystack, searchStr)).orElse(-1);
    private Function<Integer, Function<Integer, Predicate<Integer>>> isLengthValidForSubstring = haystackLength -> needleLength -> index ->
            ((haystackLength-1) - index) <= (needleLength);

    private BiPredicate<Character, Character> isCharEqual = (x,y) -> x == y;
    private final BiFunction<String, String, Integer> findIndex = (haystack, needle) -> {
        if (haystack.isEmpty() || needle.isEmpty())
            return -1;

        char needleStartingChar = needle.charAt(0);
        for(int index =0; index < haystack.length(); index++){
            if(this.isCharEqual.test(haystack.charAt(index), needleStartingChar)){
                if(this.isLengthValidForSubstring.apply(haystack.length()).apply(needle.length()).test(index)){
                    String substring = haystack.substring(index, (index+needle.length()));
                    if(needle.equals(substring)){
                        return index;
                    }
                }
            }
        }

        return -1;
    };

    public int strStr(final String haystack, final String needle) {
        return Optional.ofNullable(haystack).map(hay -> findIndexOf.apply(hay, needle)).orElse(-1);
    }

}
