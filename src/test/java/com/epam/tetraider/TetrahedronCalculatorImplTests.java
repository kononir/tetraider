package com.epam.tetraider;

import com.epam.tetraider.logic.TetrahedronCalculatorImpl;
import com.epam.tetraider.logic.interfaces.TetrahedronCalculator;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.model.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class TetrahedronCalculatorImplTests {
    @Test
    public void testCalculateSquareShouldReturnTwentyWhenInscribedRadiusEqualsTwo() {
        // given
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

        Tetrahedron tetrahedron = new Tetrahedron(topPoint, baseCenterPoint, baseTopPoint);

        double expected = 20.78;
        double delta = 0.01;

        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        double actual = tetrahedronCalculator.calculateSurfaceSquare(tetrahedron);

        // then
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void testCalculateVolumeShouldReturnFiveWhenInscribedRadiusEqualsTwo() {
        // given
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

        Tetrahedron tetrahedron = new Tetrahedron(topPoint, baseCenterPoint, baseTopPoint);

        double expected = 5.19;
        double delta = 0.01;

        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        double actual = tetrahedronCalculator.calculateVolume(tetrahedron);

        // then
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void testCalculateFigureDissectRatioShouldReturnFourteenTenthsWhenHeightLengthIsSixAndCoordinatesPlaneLiesAtCenter() {
        double topPointXCord = 5.0;
        double topPointYCord = 5.0;
        double topPointZCord = 3.0;

        Point topPoint = new Point(topPointXCord, topPointYCord, topPointZCord);

        double baseCenterPointXCord = 5.0;
        double baseCenterPointYCord = 5.0;
        double baseCenterPointZCord = -3.0;

        Point baseCenterPoint = new Point(baseCenterPointXCord, baseCenterPointYCord, baseCenterPointZCord);

        double baseTopPointXCord = 9.0;
        double baseTopPointYCord = 5.0;
        double baseTopPointZCord = -3.0;

        Point baseTopPoint = new Point(baseTopPointXCord, baseTopPointYCord, baseTopPointZCord);

        Tetrahedron tetrahedron = new Tetrahedron(topPoint, baseCenterPoint, baseTopPoint);

        double expected = 0.14;
        double delta = 0.01;

        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        double actual = tetrahedronCalculator.calculateFigureDissectRatio(tetrahedron);

        // then
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void testCalculateFigureDissectRatioShouldReturnZeroWhenTetrahedronLiesAboveCoordinatesPlane() {
        double topPointXCord = 5.0;
        double topPointYCord = 5.0;
        double topPointZCord = 7.0;

        Point topPoint = new Point(topPointXCord, topPointYCord, topPointZCord);

        double baseCenterPointXCord = 5.0;
        double baseCenterPointYCord = 5.0;
        double baseCenterPointZCord = 1.0;

        Point baseCenterPoint = new Point(baseCenterPointXCord, baseCenterPointYCord, baseCenterPointZCord);

        double baseTopPointXCord = 9.0;
        double baseTopPointYCord = 5.0;
        double baseTopPointZCord = 1.0;

        Point baseTopPoint = new Point(baseTopPointXCord, baseTopPointYCord, baseTopPointZCord);

        Tetrahedron tetrahedron = new Tetrahedron(topPoint, baseCenterPoint, baseTopPoint);

        double expected = 0;
        double delta = 0.01;

        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        double actual = tetrahedronCalculator.calculateFigureDissectRatio(tetrahedron);

        // then
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void testCalculateFigureDissectRatioShouldReturnZeroWhenTetrahedronBelowCoordinatesPlane() {
        double topPointXCord = 5.0;
        double topPointYCord = 5.0;
        double topPointZCord = -1.0;

        Point topPoint = new Point(topPointXCord, topPointYCord, topPointZCord);

        double baseCenterPointXCord = 5.0;
        double baseCenterPointYCord = 5.0;
        double baseCenterPointZCord = -7.0;

        Point baseCenterPoint = new Point(baseCenterPointXCord, baseCenterPointYCord, baseCenterPointZCord);

        double baseTopPointXCord = 9.0;
        double baseTopPointYCord = 5.0;
        double baseTopPointZCord = -7.0;

        Point baseTopPoint = new Point(baseTopPointXCord, baseTopPointYCord, baseTopPointZCord);

        Tetrahedron tetrahedron = new Tetrahedron(topPoint, baseCenterPoint, baseTopPoint);

        double expected = 0;
        double delta = 0.01;

        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        double actual = tetrahedronCalculator.calculateFigureDissectRatio(tetrahedron);

        // then
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void testIsBaseLiesAtCoordinatePlaneShouldReturnTrueWhenGivenTetrahedronBasePointsHaveZeroCoordinatesInSimilarPlane() {
        // given
        double topPointXCord = 0.0;
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

        Tetrahedron tetrahedron = new Tetrahedron(topPoint, baseCenterPoint, baseTopPoint);

        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        boolean actual = tetrahedronCalculator.isBaseLiesAtCoordinatePlane(tetrahedron);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsBaseLiesAtCoordinatePlaneShouldReturnFalseWhenGivenTetrahedronBasePointsNotHaveZeroCoordinatesInSimilarPlane() {
        // given
        double pointCord = 5.0;

        Point topPoint = new Point(pointCord, pointCord, pointCord);
        Point baseCenterPoint = new Point(pointCord, pointCord, pointCord);
        Point baseTopPoint = new Point(pointCord, pointCord, pointCord);

        Tetrahedron tetrahedron = new Tetrahedron(topPoint, baseCenterPoint, baseTopPoint);

        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        boolean actual = tetrahedronCalculator.isBaseLiesAtCoordinatePlane(tetrahedron);

        // then
        Assert.assertFalse(actual);
    }
}
