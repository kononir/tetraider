package com.epam.tetraider;

import com.epam.tetraider.logic.TetrahedronCalculatorImpl;
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

        TetrahedronCalculatorImpl tetrahedronCalculator = new TetrahedronCalculatorImpl();

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

        TetrahedronCalculatorImpl tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        double actual = tetrahedronCalculator.calculateVolume(tetrahedron);

        // then
        Assert.assertEquals(expected, actual, delta);
    }


}
