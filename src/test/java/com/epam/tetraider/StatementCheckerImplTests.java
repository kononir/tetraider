package com.epam.tetraider;

import com.epam.tetraider.logic.StatementCheckerImpl;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.model.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class StatementCheckerImplTests {
    @Test
    public void testIsTetrahedronShouldReturnTrueWhenGivenTetrahedron() {
        // given
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

        Tetrahedron tetrahedron = new Tetrahedron(topPoint, baseCenterPoint, baseTopPoint);

        StatementCheckerImpl statementChecker = new StatementCheckerImpl();

        // when
        boolean actual = statementChecker.isTetrahedron(tetrahedron);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsTetrahedronShouldReturnFalseWhenGivenOtherClassObject() {
        // given
        double pointCord = 5.0;

        Point point = new Point(pointCord, pointCord, pointCord);

        StatementCheckerImpl statementChecker = new StatementCheckerImpl();

        // when
        boolean actual = statementChecker.isTetrahedron(point);

        // then
        Assert.assertFalse(actual);
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

        StatementCheckerImpl statementChecker = new StatementCheckerImpl();

        // when
        boolean actual = statementChecker.isBaseLiesAtCoordinatePlane(tetrahedron);

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

        StatementCheckerImpl statementChecker = new StatementCheckerImpl();

        // when
        boolean actual = statementChecker.isBaseLiesAtCoordinatePlane(tetrahedron);

        // then
        Assert.assertFalse(actual);
    }
}
