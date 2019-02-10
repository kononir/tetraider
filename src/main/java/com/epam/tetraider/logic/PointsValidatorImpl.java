package com.epam.tetraider.logic;

import com.epam.tetraider.logic.interfaces.PointsValidator;
import com.epam.tetraider.model.Point;

public class PointsValidatorImpl implements PointsValidator {
    @Override
    public boolean isValidPoints(Point topPoint, Point baseCenterPoint, Point baseTopPoint) {
        return !isNonEqualsPoints(topPoint, baseCenterPoint, baseTopPoint)
                && isBasePointsLiesHorizontal(baseCenterPoint, baseTopPoint)
                && isHeightPointsLiesVertical(topPoint, baseCenterPoint)
                && isConsistentPoints(topPoint, baseCenterPoint, baseTopPoint);
    }

    private boolean isNonEqualsPoints(Point topPoint, Point baseCenterPoint, Point baseTopPoint) {
        return !topPoint.equals(baseCenterPoint)
                && !baseCenterPoint.equals(baseTopPoint)
                && !baseTopPoint.equals(topPoint);
    }

    private boolean isBasePointsLiesHorizontal(Point baseCenterPoint, Point baseTopPoint) {
        double baseCenterPointZCord = baseCenterPoint.getZCord();
        double baseTopPointZCord = baseTopPoint.getZCord();

        return (baseCenterPointZCord == baseTopPointZCord);
    }

    private boolean isHeightPointsLiesVertical(Point topPoint, Point baseCenterPoint) {
        double topPointXCord = topPoint.getXCord();
        double topPointYCord = topPoint.getYCord();

        double baseCenterPointXCord = baseCenterPoint.getXCord();
        double baseCenterPointYCord = baseCenterPoint.getYCord();

        return ((topPointXCord == baseCenterPointXCord) && (topPointYCord == baseCenterPointYCord));
    }

    private boolean isConsistentPoints(Point topPoint, Point baseCenterPoint, Point baseTopPoint) {
        TetrahedronCalculatorImpl calculator = new TetrahedronCalculatorImpl();

        double inscribedRadius = calculator.calculateDistanceBetweenPoints(baseCenterPoint, baseTopPoint);
        double expectedHeight = calculator.calculateHeight(inscribedRadius);

        double actualHeight = calculator.calculateDistanceBetweenPoints(topPoint, baseCenterPoint);

        double delta = 0.01;

        return (Math.abs(actualHeight - expectedHeight) < delta);
    }
}
