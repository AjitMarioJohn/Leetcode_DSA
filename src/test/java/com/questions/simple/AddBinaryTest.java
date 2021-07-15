package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AddBinaryTest {

    private AddBinary addBinary;

    private static Stream<Arguments> input(){
        return Stream.of(
                Arguments.of("11","1","100"),
                Arguments.of("1010","1011","10101"),
                Arguments.of("00","1","01")
        );
    }

    @BeforeEach
    private void initialize(){
        addBinary = new AddBinary();
    }

    @ParameterizedTest
    @MethodSource(value = "input")
    public void testAddBinary(String a, String b, String output){
        Assertions.assertEquals(output, addBinary.addBinary(a,b));
    }
}
