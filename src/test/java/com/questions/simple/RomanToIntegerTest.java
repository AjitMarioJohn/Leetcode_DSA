package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanToIntegerTest {

    private RomanToInteger romanToInteger;

    @BeforeEach
    private void initialize(){
        romanToInteger = new RomanToInteger();
    }

    @ParameterizedTest
    @CsvSource(value = {"III:3","IV:4","IX:9","LVIII:58", ":0"}, delimiter = ':')
    public void validateRomanToInt(String input, int output){
        Assertions.assertEquals(output, this.romanToInteger.romanToInt(input));
    }

}
