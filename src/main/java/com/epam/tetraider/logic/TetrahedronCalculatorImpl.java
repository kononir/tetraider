package com.epam.tetraider.logic;

import com.epam.tetraider.interfaces.TetrahedronCalculator;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.model.Tetrahedron;

public class TetrahedronCalculatorImpl implements TetrahedronCalculator {
    @Override
    public double calculateSurfaceSquare(Tetrahedron tetrahedron) {
        Point baseTopPoint = tetrahedron.getBaseTopPoint();
        Point baseCenterPoint = tetrahedron.getBaseCenterPoint();

        double inscribedRadius = calculateDistanceBetweenPoints(baseTopPoint, baseCenterPoint);
        double faceSquare = calculateFaceSquare(inscribedRadius);

        int facesNumber = 4;

        return facesNumber * faceSquare;
    }

    @Override
    public double calculateVolume(Tetrahedron tetrahedron) {
        Point baseTopPoint = tetrahedron.getBaseTopPoint();
        Point baseCenterPoint = tetrahedron.getBaseCenterPoint();

        double inscribedRadius = calculateDistanceBetweenPoints(baseTopPoint, baseCenterPoint);

        double faceSquare = calculateFaceSquare(inscribedRadius);
        double height = calculateHeight(inscribedRadius);

        double coefficient = 1.0 / 3.0;

        return coefficient * faceSquare * height;
    }

    @Override
    public double calculateFigureDissectRatio(Tetrahedron tetrahedron) {
        return 0;
    }

    private double calculateFaceSquare(double inscribedRadius) {

        double side = calculateSide(inscribedRadius);
        double height = calculateHeight(inscribedRadius);

        double coefficient = 1.0 / 2.0;

        return coefficient * side * height;
    }

    private double calculateSide(double inscribedRadius) {
        return inscribedRadius * Math.sqrt(3.0);
    }

    private double calculateHeight(double inscribedRadius) {
        double coefficient = 3.0 / 2.0;

        return coefficient * inscribedRadius;
    }

    private double calculateDistanceBetweenPoints(Point firstPoint, Point secondPoint) {
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
