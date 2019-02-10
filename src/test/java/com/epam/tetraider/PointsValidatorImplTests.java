package com.epam.tetraider;

import com.epam.tetraider.logic.PointsValidatorImpl;
import com.epam.tetraider.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class PointsValidatorImplTests {
    @Test
    public void testIsValidPointsShouldReturnTrueWhenPointsDefineTetrahedronThatParallelCoordinatesPlane() {
        // given
        PointsValidatorImpl pointsValidator = new PointsValidatorImpl();

        double topPointXCord = 5;
        double topPointYCord = 5;
        double topPointZCord = 5;

        Point topPoint = new Point(topPointXCord, topPointYCord, topPointZCord);

        double baseCenterPointXCord = 5;
        double baseCenterPointYCord = 5;
        double baseCenterPointZCord = 2;

        Point baseCenterPoint = new Point(baseCenterPointXCord, baseCenterPointYCord, baseCenterPointZCord);

        double baseTopPointXCord = 3;
        double baseTopPointYCord = 5;
        double baseTopPointZCord = 2;

        Point baseTopPoint = new Point(baseTopPointXCord, baseTopPointYCord, baseTopPointZCord);

        // when
        boolean actual = pointsValidator.isValidPoints(topPoint, baseCenterPoint, baseTopPoint);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidPointsShouldReturnFalseWhenPointsEquals() {
        // given
        PointsValidatorImpl pointsValidator = new PointsValidatorImpl();

        double topPointXCord = 5;
        double topPointYCord = 5;
        double topPointZCord = 5;

        Point topPoint = new Point(topPointXCord, topPointYCord, topPointZCord);

        double baseCenterPointXCord = 5;
        double baseCenterPointYCord = 5;
        double baseCenterPointZCord = 5;

        Point baseCenterPoint = new Point(baseCenterPointXCord, baseCenterPointYCord, baseCenterPointZCord);

        double baseTopPointXCord = 3;
        double baseTopPointYCord = 5;
        double baseTopPointZCord = 2;

        Point baseTopPoint = new Point(baseTopPointXCord, baseTopPointYCord, baseTopPointZCord);

        // when
        boolean actual = pointsValidator.isValidPoints(topPoint, baseCenterPoint, baseTopPoint);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidPointsShouldReturnFalseWhenPointsNotLieHorizontal() {
        // given
        PointsValidatorImpl pointsValidator = new PointsValidatorImpl();

        double topPointXCord = 5.0;
        double topPointYCord = 5.0;
        double topPointZCord = 5.0;

        Point topPoint = new Point(topPointXCord, topPointYCord, topPointZCord);

        double baseCenterPointXCord = 5.0;
        double baseCenterPointYCord = 5.0;
        double baseCenterPointZCord = 100000000.0;

        Point baseCenterPoint = new Point(baseCenterPointXCord, baseCenterPointYCord, baseCenterPointZCord);

        double baseTopPointXCord = 5.0;
        double baseTopPointYCord = 5.0;
        double baseTopPointZCord = 0.0;

        Point baseTopPoint = new Point(baseTopPointXCord, baseTopPointYCord, baseTopPointZCord);

        // when
        boolean actual = pointsValidator.isValidPoints(topPoint, baseCenterPoint, baseTopPoint);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidPointsShouldReturnFalseWhenPointsNotLieVertical() {
        // given
        PointsValidatorImpl pointsValidator = new PointsValidatorImpl();

        double topPointXCord = 5.0;
        double topPointYCord = 5.0;
        double topPointZCord = 5.0;

        Point topPoint = new Point(topPointXCord, topPointYCord, topPointZCord);

        double baseCenterPointXCord = 100000000.0;
        double baseCenterPointYCord = 100000000.0;
        double baseCenterPointZCord = 0.0;

        Point baseCenterPoint = new Point(baseCenterPointXCord, baseCenterPointYCord, baseCenterPointZCord);

        double baseTopPointXCord = 5.0;
        double baseTopPointYCord = 5.0;
        double baseTopPointZCord = 0.0;

        Point baseTopPoint = new Point(baseTopPointXCord, baseTopPointYCord, baseTopPointZCord);

        // when
        boolean actual = pointsValidator.isValidPoints(topPoint, baseCenterPoint, baseTopPoint);

        // then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidPointsShouldReturnFalseWhenPointsIsConsistence() {
        // given
        PointsValidatorImpl pointsValidator = new PointsValidatorImpl();

        double topPointXCord = 5.0;
        double topPointYCord = 5.0;
        double topPointZCord = 5.0;

        Point topPoint = new Point(topPointXCord, topPointYCord, topPointZCord);

        double baseCenterPointXCord = 5.0;
        double baseCenterPointYCord = 5.0;
        double baseCenterPointZCord = 0.0;

        Point baseCenterPoint = new Point(baseCenterPointXCord, baseCenterPointYCord, baseCenterPointZCord);

        double baseTopPointXCord = 1000000000.0;
        double baseTopPointYCord = 1000000000.0;
        double baseTopPointZCord = 0.0;

        Point baseTopPoint = new Point(baseTopPointXCord, baseTopPointYCord, baseTopPointZCord);

        // when
        boolean actual = pointsValidator.isValidPoints(topPoint, baseCenterPoint, baseTopPoint);

        // then
        Assert.assertFalse(actual);
    }
}
