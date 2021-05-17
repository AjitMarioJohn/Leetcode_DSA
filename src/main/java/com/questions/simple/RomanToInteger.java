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

    private Function<String, Integer> convert = (str) -> this.convertReverseStringToIntStream.apply(str).map(this.resultantNumber).sum();

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
}
