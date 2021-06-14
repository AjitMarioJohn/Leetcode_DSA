package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LengthOfLastWordTest {

    private LengthOfLastWord lengthOfLastWord;

    private static final Stream<Arguments> input(){
        return Stream.of(
                Arguments.of("Hello World",5),
                Arguments.of(" ",0),
                Arguments.of(null,0),
                Arguments.of("",0)
        );
    }

    @BeforeEach
    private void initialize(){
        lengthOfLastWord = new LengthOfLastWord();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testLengthOfLastWord(String input, int output){
        Assertions.assertEquals(output, lengthOfLastWord.lengthOfLastWord(input));
    }

}
