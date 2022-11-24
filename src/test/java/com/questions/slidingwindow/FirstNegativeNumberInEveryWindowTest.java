package com.questions.slidingwindow;

import com.questions.utils.StringToLongArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class FirstNegativeNumberInEveryWindowTest {
    FirstNegativeNumberInEveryWindow firstNegativeNumberInEveryWindow;

    @BeforeEach
    void initialize() {
        firstNegativeNumberInEveryWindow = new FirstNegativeNumberInEveryWindow();
    }



    @ParameterizedTest
    @CsvSource(value = {"[-8, 2, 3, -6, 10]:5:2:[-8,0,-6,-6]", "[ 12, -1, -7, 8, -15, 30, 16, 28]:8:3:[-1, -1, -7, -15, -15, 0]"}, delimiter = ':')
    void testPrintFirstNegativeInteger(@ConvertWith(StringToLongArrayConverter.class)long[] inputArr,
                                       int arrSize, int k,
                                       @ConvertWith(StringToLongArrayConverter.class)long[] expected) {
        long[] result = firstNegativeNumberInEveryWindow.printFirstNegativeInteger(inputArr, arrSize, k);
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result).isEqualTo(expected);
    }
}
