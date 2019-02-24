package com.epam.tetraider.data;

import com.epam.tetraider.logic.interfaces.PointsValidator;
import com.epam.tetraider.model.point.Point;
import org.junit.Assert;
import org.junit.Test;

public class PointsValidatorImplTests {
    private static final Point FIRST_POINT = new Point(5, 5, 5);
    private static final Point SECOND_POINT = new Point(5, 5, 2);
    private static final Point THIRD_POINT = new Point(3, 5, 2);
    private static final Point FOURTH_POINT = new Point(5, 5, 100000000);
    private static final Point FIFTH_POINT = new Point(5, 5, 0);
    private static final Point SIXTH_POINT = new Point(100000000, 100000000, 0);

    @Test
    public void testIsValidPointsShouldReturnTrueWhenPointsDefineTetrahedronThatParallelCoordinatesPlane() {
        // given
        PointsValidator pointsValidator = new PointsValidatorImpl();

        // when
        boolean actual = pointsValidator.isValidPoints(FIRST_POINT, SECOND_POINT, THIRD_POINT);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidPointsShouldReturnFalseWhenPointsEquals() {
        // given
        PointsValidator pointsValidator = new PointsValidatorImpl();
        // when
        boolean actual = pointsValidator.isValidPoints(FIRST_POINT, FIRST_POINT, THIRD_POINT);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidPointsShouldReturnFalseWhenPointsNotLieHorizontal() {
        // given
        PointsValidator pointsValidator = new PointsValidatorImpl();

        // when
        boolean actual = pointsValidator.isValidPoints(FIRST_POINT, FOURTH_POINT, FIFTH_POINT);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidPointsShouldReturnFalseWhenPointsNotLieVertical() {
        // given
        PointsValidator pointsValidator = new PointsValidatorImpl();

        // when
        boolean actual = pointsValidator.isValidPoints(FIRST_POINT, SIXTH_POINT, FIFTH_POINT);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidPointsShouldReturnFalseWhenPointsIsConsistence() {
        // given
        PointsValidator pointsValidator = new PointsValidatorImpl();

        // when
        boolean actual = pointsValidator.isValidPoints(FIRST_POINT, FIFTH_POINT, SIXTH_POINT);

        // then
        Assert.assertFalse(actual);
    }
}
