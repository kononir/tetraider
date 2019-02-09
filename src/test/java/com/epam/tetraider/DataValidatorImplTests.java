package com.epam.tetraider;

import com.epam.tetraider.logic.DataValidatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class DataValidatorImplTests {
    @Test
    public void testIsValidLineShouldReturnTrueWhenInputHasThreeNumbers() {
        // given
        final DataValidatorImpl dataValidator = new DataValidatorImpl();
        final String dataLine = "5.0 5.0 5.0";

        // when
        boolean actual = dataValidator.isValidLine(dataLine);

        // then
        Assert.assertTrue(actual);
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
        final String dataLine = "5.0 5.0 5.0 5.0";

        // when
        boolean actual = dataValidator.isValidLine(dataLine);

        // then
        Assert.assertFalse(actual);
    }
}
