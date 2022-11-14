package com.questions.utils;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.Arrays;
import java.util.Objects;

/**
 * Converter class that converts String array to integer array
 */
public class StringToIntegerArrayConverter  extends SimpleArgumentConverter {
    @Override
    protected int[] convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        int[] param = new int[]{};
        if (Objects.isNull(source)) {
            return param;
        }
        if (source instanceof String && int[].class.isAssignableFrom(targetType)) {
            String inputStr = String.valueOf(source);
            param = Arrays.stream((inputStr.replace('[',' ')).replace(']',' ')
                    .trim().split(",")).mapToInt(Integer :: parseInt).toArray();
            return param;
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported.");
        }
    }
}
