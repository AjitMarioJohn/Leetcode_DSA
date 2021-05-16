package com.questions.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidParenthesisTest {

    static ValidParenthesis validParenthesis;

    @BeforeEach
    void initiate(){
        validParenthesis = new ValidParenthesis();
    }

    @Test
    @ParameterizedTest
    @ValueSource(strings = { "((", "({)}", "{([)}]","))" })
    public void testInvalid(String parenthesis){
        Assertions.assertFalse(validParenthesis.isValid(parenthesis));
    }

    @Test
    @ParameterizedTest
    @ValueSource(strings = { "()", "({})", "[{()}]" })
    public void testValid(String parenthesis){
        Assertions.assertTrue(validParenthesis.isValid(parenthesis));
    }

}
