package com.questions.slidingwindow;

import com.questions.utils.StringToIntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSumSubArrayTest {
    MaximumSumSubArray sut;
    final int sizeOfSubArray = 3;

    @BeforeEach
    void initialize() {
        sut = new MaximumSumSubArray();
    }

    @ParameterizedTest
    @DisplayName("Maximum sum of subarray should be")
    @CsvSource(value = {"[4,2,1,7,8,1,2,8,1,0]:16"}, delimiter = ':')
    public void testGetMaximumSumOfSubArray(@ConvertWith(StringToIntegerArrayConverter.class) int[] input, int output) {
        assertEquals(output, sut.getMaximumSumOfSubArray(input,sizeOfSubArray));
    }

}