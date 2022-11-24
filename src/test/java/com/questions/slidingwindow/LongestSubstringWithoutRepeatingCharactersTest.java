package com.questions.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringWithoutRepeatingCharactersTest {

    static LongestSubstringWithoutRepeatingCharacters obj;

    @BeforeEach
    void initialize(){
        obj = new LongestSubstringWithoutRepeatingCharacters();
    }

    @ParameterizedTest
    @DisplayName("LongestCommonPrefix should ")
    @CsvSource(value = {"abcabcbb:3", "bbbbb:1", "pwwkew:3", "abcabcbbabcabcbbabcabcbb:3",":0"}, delimiter = ':')
    void testLongestCommonPrefix(String input, int output){
        assertThat(this.obj.lengthOfLongestSubstring(input,3)).isEqualTo(output);
    }

    @ParameterizedTest
    @NullSource
    void testLongestCommonPrefixForNull(String input){
        assertThat(this.obj.lengthOfLongestSubstring(input,3)).isZero();
    }

    @ParameterizedTest
    @EmptySource
    void testLongestCommonPrefixForEmpty(String input){
        assertThat(this.obj.lengthOfLongestSubstring(input,3)).isZero();
    }
}
