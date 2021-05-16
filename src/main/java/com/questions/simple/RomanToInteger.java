package com.questions.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;

public class RomanToInteger {

    private final Map<String, Integer> romanToIntMapper = new HashMap<>(){{
        put("I", 1);
        put("V",5);
        put("X",10);
        put("L",50);
        put("C",100);
        put("D",500);
        put("M",1000);
    }};

    private final Stack<String> lastLetter = new Stack<>();

    public int romanToInt(String input) {
        return this.convertRomanToInt.apply(input);
    }

    private Function<String,Integer> convertRomanToInt = (romanStr) -> Optional.ofNullable(romanStr).map(this.convert).orElse(0);

    private Function<String, Integer> convert = (str) -> {
        return 0;
    };

    private IntFunction<String> convertIntToString = (value) -> Character.toString((char)value);

}
