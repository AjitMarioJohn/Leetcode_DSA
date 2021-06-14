package com.questions.simple;

import java.util.function.*;

public class PlusOne {

    private Function<int[], Integer> incrementLastIndexNum = (arr) -> arr[arr.length - 1] + 1;
    private BiFunction<int[], Integer, Function<Integer, int[]>> swapValueToDesiredPosition = (arr, value) -> position -> {
        arr[position] = value;
        return arr;
    };
    private BiFunction<int[], Integer, int[]> swapLastIndexValue = (arr, value) -> this.swapValueToDesiredPosition.apply(arr, value).apply(arr.length - 1);
    private BiPredicate<Integer, Integer> isNumLessOrEqualToLimit = (num, limit) -> num <= limit;
    private IntPredicate isNumLessThanOrEqualToNine = (num) -> this.isNumLessOrEqualToLimit.test(num, 9);
    private Function<Integer, int[]> splitNumToArray = (num) -> Integer.toString(num).chars().map(c -> c - '0').toArray();
    private Predicate<int[]> isMergingRequired = arr -> arr.length > 1;

    public int[] plusOne(int[] input) {

        int incrementedNum = this.incrementLastIndexNum.apply(input);

        if (this.isNumLessThanOrEqualToNine.test(incrementedNum)) {
            return this.swapLastIndexValue.apply(input, incrementedNum);
        }

        if (this.isMergingRequired.negate().test(input)) {
            return this.splitNumToArray.apply(incrementedNum);
        }

        return null;
    }
}
