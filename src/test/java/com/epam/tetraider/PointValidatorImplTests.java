package com.epam.tetraider;

import com.epam.tetraider.logic.PointValidatorImpl;
import com.epam.tetraider.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class PointValidatorImplTests {
    @Test
    public void testIsValidPointsShouldReturnTrueWhenPointsDefineTetrahedronThatParallelCoordinatesPlane() {
        // given
        PointValidatorImpl pointValidator = new PointValidatorImpl();

        double topPointXCord = 0;
        double topPointYCord = 0;
        double topPointZCord = 6;

        Point topPoint = new Point(topPointXCord, topPointYCord, topPointZCord);

        double baseCenterPointXCord = 0;
        double baseCenterPointYCord = 0;
        double baseCenterPointZCord = 0;

        Point baseCenterPoint = new Point(baseCenterPointXCord, baseCenterPointYCord, baseCenterPointZCord);

        double baseTopPointXCord = 2;
        double baseTopPointYCord = 0;
        double baseTopPointZCord = 0;

        Point baseTopPoint = new Point(baseTopPointXCord, baseTopPointYCord, baseTopPointZCord);

        // when
        boolean actual = pointValidator.isValidPoints(topPoint, baseCenterPoint, baseTopPoint);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidPointsShouldReturnFalseWhenPointsNotDefineTetrahedron() {
        // given
        PointValidatorImpl pointValidator = new PointValidatorImpl();

        double topPointXCord = 5.0;
        double topPointYCord = 5.0;
        double topPointZCord = 5.0;

        Point topPoint = new Point(topPointXCord, topPointYCord, topPointZCord);

        double baseCenterPointXCord = 5.0;
        double baseCenterPointYCord = 10.0;
        double baseCenterPointZCord = 100000000.0;

        Point baseCenterPoint = new Point(baseCenterPointXCord, baseCenterPointYCord, baseCenterPointZCord);

        double baseTopPointXCord = 5.0;
        double baseTopPointYCord = 5.0;
        double baseTopPointZCord = 0.0;

        Point baseTopPoint = new Point(baseTopPointXCord, baseTopPointYCord, baseTopPointZCord);

        // when
        boolean actual = pointValidator.isValidPoints(topPoint, baseCenterPoint, baseTopPoint);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidPointsShouldReturnFalseWhenPointsNotDefineTetrahedronThatParallelCoordinatesPlane() {
        // given
        PointValidatorImpl pointValidator = new PointValidatorImpl();

        double topPointXCord = 5.0;
        double topPointYCord = 5.0;
        double topPointZCord = 5.0;

        Point topPoint = new Point(topPointXCord, topPointYCord, topPointZCord);

        double baseCenterPointXCord = 5.0;
        double baseCenterPointYCord = 10.0;
        double baseCenterPointZCord = 0.0;

        Point baseCenterPoint = new Point(baseCenterPointXCord, baseCenterPointYCord, baseCenterPointZCord);

        double baseTopPointXCord = 5.0;
        double baseTopPointYCord = 5.0;
        double baseTopPointZCord = 0.0;

        Point baseTopPoint = new Point(baseTopPointXCord, baseTopPointYCord, baseTopPointZCord);

        // when
        boolean actual = pointValidator.isValidPoints(topPoint, baseCenterPoint, baseTopPoint);

        // then
        Assert.assertTrue(actual);
    }
}
