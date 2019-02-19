package com.epam.tetraider.data;

import com.epam.tetraider.data.DataValidatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class DataValidatorImplTests {
    @Test
    public void testIsValidLineShouldReturnTrueWhenInputHasNineDoubles() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();
        final String dataLine = "1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0";

        // when
        boolean actual = dataValidator.isValidLine(dataLine);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidLineShouldReturnTrueWhenInputHasNineNegativeDoubles() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();
        final String dataLine = "-1.0 -2.0 -3.0 -4.0 -5.0 -6.0 -7.0 -8.0 -9.0";

        // when
        boolean actual = dataValidator.isValidLine(dataLine);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidLineShouldReturnFalseWhenInputHasNineIntegers() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();
        final String dataLine = "1 2 3 4 5 6 7 8 9";

        // when
        boolean actual = dataValidator.isValidLine(dataLine);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidLineShouldReturnFalseWhenInputHasCharacter() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();
        final String dataLine = "a";

        // when
        boolean actual = dataValidator.isValidLine(dataLine);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidLineShouldReturnFalseWhenInputHasNotEnoughNumbers() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();
        final String dataLine = "5.0";

        // when
        boolean actual = dataValidator.isValidLine(dataLine);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidLineShouldReturnFalseWhenInputHasTooManyNumbers() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();
        final String dataLine = "1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 10.0";

        // when
        boolean actual = dataValidator.isValidLine(dataLine);

        // then
        Assert.assertFalse(actual);
    }
}
