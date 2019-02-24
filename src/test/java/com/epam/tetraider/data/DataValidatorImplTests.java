package com.epam.tetraider.data;

import org.junit.Assert;
import org.junit.Test;

public class DataValidatorImplTests {
    private static final String NINE_DOUBLES = "1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0";
    private static final String NINE_NEGATIVE_DOUBLES = "-1.0 -2.0 -3.0 -4.0 -5.0 -6.0 -7.0 -8.0 -9.0";
    private static final String NINE_INTEGERS = "1 2 3 4 5 6 7 8 9";
    private static final String LETTER = "a";
    private static final String NOT_ENOUGH_DOUBLE = "5.0";
    private static final String TOO_ENOUGH_DOUBLE = "1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 10.0";

    @Test
    public void testIsValidLineShouldReturnTrueWhenInputHasNineDoubles() {
        // given
        DataValidatorImpl dataValidator = new DataValidatorImpl();

        // when
        boolean actual = dataValidator.isValidLine(NINE_DOUBLES);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidLineShouldReturnTrueWhenInputHasNineNegativeDoubles() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();

        // when
        boolean actual = dataValidator.isValidLine(NINE_NEGATIVE_DOUBLES);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidLineShouldReturnFalseWhenInputHasNineIntegers() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();

        // when
        boolean actual = dataValidator.isValidLine(NINE_INTEGERS);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidLineShouldReturnFalseWhenInputHasCharacter() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();

        // when
        boolean actual = dataValidator.isValidLine(LETTER);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidLineShouldReturnFalseWhenInputHasNotEnoughNumbers() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();

        // when
        boolean actual = dataValidator.isValidLine(NOT_ENOUGH_DOUBLE);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidLineShouldReturnFalseWhenInputHasTooManyNumbers() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();

        // when
        boolean actual = dataValidator.isValidLine(TOO_ENOUGH_DOUBLE);

        // then
        Assert.assertFalse(actual);
    }
}
