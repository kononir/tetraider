package com.epam.tetraider.logic;

import com.epam.tetraider.logic.interfaces.LineCalculator;
import com.epam.tetraider.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class LineCalculatorImplTests {
    private static final Point FIRST_POINT = new Point(0, 0, 25);
    private static final Point SECOND_POINT = new Point(0, 0, 0);

    private static final double TWENTY_FIVE = 25;
    private static final double TWELVE_AND_HALF = 12.5;
    private static final double DELTA = 0.01;

    @Test
    public void testCalculateDistanceBetweenPointsShouldReturnTwentyFiveWhenLiesAtVerticalLine() {
        // given
        LineCalculator calculator = new LineCalculatorImpl();

        // when
        double actual = calculator.calculateDistanceBetweenPoints(FIRST_POINT, SECOND_POINT);

        // then
        Assert.assertEquals(TWENTY_FIVE, actual, DELTA);
    }

    @Test
    public void testFindCenterOfHorizontalLineShouldReturnTwelveAndHalfWhenZOfAbovePointIsTwentyFive() {
        // given
        LineCalculator calculator = new LineCalculatorImpl();

        // when
        Point point = calculator.findCenterOfHorizontalLine(FIRST_POINT, SECOND_POINT);

        // then
        double actual = point.getZCord();
        Assert.assertEquals(TWELVE_AND_HALF, actual, DELTA);
    }

    @Test
    public void testFindCenterOfHorizontalLineShouldReturnTwelveAndHalfWhenZOfAbovePointIsZero() {
        // given
        LineCalculator calculator = new LineCalculatorImpl();

        // when
        Point point = calculator.findCenterOfHorizontalLine(SECOND_POINT, FIRST_POINT);

        // then
        double actual = point.getZCord();
        Assert.assertEquals(TWELVE_AND_HALF, actual, DELTA);
    }
}
