package com.epam.tetraider.logic;

import com.epam.tetraider.logic.interfaces.LineCalculator;
import com.epam.tetraider.model.Point;

public class LineCalculatorImpl implements LineCalculator {
    @Override
    public double calculateDistanceBetweenPoints(Point firstPoint, Point secondPoint) {
        double firstPointXCord = firstPoint.getXCord();
        double secondPointXCord = secondPoint.getXCord();

        double deltaX = firstPointXCord - secondPointXCord;
        double squaredDeltaX = deltaX * deltaX;

        double firstPointYCord = firstPoint.getYCord();
        double secondPointYCord = secondPoint.getYCord();

        double deltaY = firstPointYCord - secondPointYCord;
        double squaredDeltaY = deltaY * deltaY;

        double firstPointZCord = firstPoint.getZCord();
        double secondPointZCord = secondPoint.getZCord();

        double deltaZ = firstPointZCord - secondPointZCord;
        double squaredDeltaZ = deltaZ * deltaZ;

        return Math.sqrt(squaredDeltaX + squaredDeltaY + squaredDeltaZ);
    }
}
