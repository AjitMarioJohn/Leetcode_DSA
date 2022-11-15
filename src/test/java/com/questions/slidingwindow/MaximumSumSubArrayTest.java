package com.questions.slidingwindow;

import com.questions.utils.StringToIntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

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
        assertThat(sut.getMaximumSumOfSubArray(input,sizeOfSubArray), comparesEqualTo(output));
    }

}