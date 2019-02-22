package com.epam.tetraider.logic;

import com.epam.tetraider.logic.interfaces.LineCalculator;
import com.epam.tetraider.model.Point;

public class LineCalculatorImpl implements LineCalculator {
    @Override
    public double calculateDistanceBetweenPoints(Point firstPoint, Point secondPoint) {
        double firstPointXCord = firstPoint.getXCord();
        double secondPointXCord = secondPoint.getXCord();

        double squaredDeltaX = calculateSquaredDelta(firstPointXCord, secondPointXCord);

        double firstPointYCord = firstPoint.getYCord();
        double secondPointYCord = secondPoint.getYCord();

        double squaredDeltaY = calculateSquaredDelta(firstPointYCord, secondPointYCord);

        double firstPointZCord = firstPoint.getZCord();
        double secondPointZCord = secondPoint.getZCord();

        double squaredDeltaZ = calculateSquaredDelta(firstPointZCord, secondPointZCord);

        return Math.sqrt(squaredDeltaX + squaredDeltaY + squaredDeltaZ);
    }

    @Override
    public Point findCenterOfHorizontalLine(Point firstPoint, Point secondPoint) {
        double xCord = firstPoint.getXCord();
        double yCord = firstPoint.getYCord();

        double vertical = calculateDistanceBetweenPoints(firstPoint, secondPoint);
        double coefficient = 2;
        double verticalHalf = vertical / coefficient;

        double firstPointZCord = firstPoint.getZCord();
        double secondPointZCord = secondPoint.getZCord();

        boolean firstPointLiesBelow = (firstPointZCord < secondPointZCord);

        double zCord = firstPointLiesBelow ? firstPointZCord + verticalHalf : firstPointZCord - verticalHalf;

        return new Point(xCord, yCord, zCord);
    }

    private double calculateSquaredDelta(double firstPointCord, double secondPointCord) {
        double delta = firstPointCord - secondPointCord;
        return delta * delta;
    }
}
