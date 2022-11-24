package com.questions.utils;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.Arrays;
import java.util.Objects;

/**
 * Converter to convert String array to long array
 */
public class StringToLongArrayConverter extends SimpleArgumentConverter {
    @Override
    protected long[] convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        long[] param = new long[]{};
        if (Objects.isNull(source)) {
            return param;
        }
        if (source instanceof String && long[].class.isAssignableFrom(targetType)) {
            String inputStr = String.valueOf(source);
            param = Arrays.stream((inputStr.replace('[',' ')).replace(']',' ')
                    .trim().split(",")).map(String :: trim).mapToLong(Long :: parseLong).toArray();
            return param;
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported.");
        }
    }
}
