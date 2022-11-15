package com.questions.slidingwindow;

import com.questions.utils.StringToIntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;

import static org.assertj.core.api.Assertions.assertThat;


public class SmallestSubArrayWithGivenSumTest {

    private SmallestSubArrayWithGivenSum sut;

    @BeforeEach
    private void initialize() {
        sut = new SmallestSubArrayWithGivenSum();
    }

    @ParameterizedTest
    @org.junit.jupiter.api.DisplayName("Maximum sum of subarray should be")
    @org.junit.jupiter.params.provider.CsvSource(value = {"[4,2,2,7,8,1,2,8,10]:8:1"}, delimiter = ':')
    public void testGetSmalledSubArrayOfGivenSum(@ConvertWith(StringToIntegerArrayConverter.class) int[] inputArr, int sumProvided,
                                                 int expected) {
        int result = sut.getSmalledSubArrayOfGivenSum(inputArr, sumProvided);
        assertThat(result).isEqualTo(expected);
    }
}
