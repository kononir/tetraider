package com.epam.tetraider.logic;

import com.epam.tetraider.logic.interfaces.LineCalculator;
import com.epam.tetraider.logic.interfaces.TetrahedronCalculator;
import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.model.tetrahedron.Tetrahedron;

public class TetrahedronCalculatorImpl implements TetrahedronCalculator {

    @Override
    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        double inscribedRadius = calculateInscribedRadius(tetrahedron);

        double faceSquare = calculateFaceSquare(inscribedRadius);

        int facesNumber = 4;

        return facesNumber * faceSquare;
    }

    @Override
    public double calculateVolume(Tetrahedron tetrahedron) {
        double inscribedRadius = calculateInscribedRadius(tetrahedron);

        return calculateVolumeByInscribedRadius(inscribedRadius);
    }

    @Override
    public double calculateFigureDissectRatio(Tetrahedron tetrahedron) {
        Point topPoint = tetrahedron.getTopPoint();
        Point baseCenterPoint = tetrahedron.getBaseCenterPoint();
        Point baseTopPoint = tetrahedron.getBaseTopPoint();

        LineCalculator lineCalculator = new LineCalculatorImpl();

        double mainTetrahedronHeight = lineCalculator.calculateDistanceBetweenPoints(topPoint, baseCenterPoint);
        double smallTetrahedronHeight = calculateSmallTetrahedronHeight(topPoint, baseCenterPoint);

        double result;

        if (smallTetrahedronHeight < mainTetrahedronHeight) {
            double proportion = smallTetrahedronHeight / mainTetrahedronHeight;

            double mainTetrahedronInscribedRadius = lineCalculator.calculateDistanceBetweenPoints(
                    baseTopPoint, baseCenterPoint
            );
            double smallTetrahedronInscribedRadius = proportion * mainTetrahedronInscribedRadius;

            double mainTetrahedronVolume = calculateVolumeByInscribedRadius(mainTetrahedronInscribedRadius);
            double smallTetrahedronVolume = calculateVolumeByInscribedRadius(smallTetrahedronInscribedRadius);

            double truncatedTetrahedronVolume = mainTetrahedronVolume - smallTetrahedronVolume;

            result = smallTetrahedronVolume / truncatedTetrahedronVolume;
        } else {
            result = 0;
        }

        return result;
    }

    @Override
    public boolean isBaseLiesAtCoordinatePlane(Tetrahedron tetrahedron) {
        Point baseTopPoint = tetrahedron.getBaseTopPoint();
        Point baseCenterPoint = tetrahedron.getBaseCenterPoint();

        double baseTopPointZCord = baseTopPoint.getZCord();
        double baseCenterPointZCord = baseCenterPoint.getZCord();

        return (baseTopPointZCord == 0 && baseCenterPointZCord == 0);
    }

    private double calculateSmallTetrahedronHeight(Point topPoint, Point baseCenterPoint) {
        double intersectionPointXCord = topPoint.getXCord();
        double intersectionPointYCord = topPoint.getYCord();
        double intersectionPointZCord = 0;
        Point intersectionCenterPoint = new Point(intersectionPointXCord, intersectionPointYCord, intersectionPointZCord);

        LineCalculator lineCalculator = new LineCalculatorImpl();

        double smallTetrahedronHeight;

        if (topPoint.getZCord() > 0) {
            smallTetrahedronHeight = lineCalculator.calculateDistanceBetweenPoints(topPoint, intersectionCenterPoint);
        } else {
            smallTetrahedronHeight = lineCalculator.calculateDistanceBetweenPoints(baseCenterPoint, intersectionCenterPoint);
        }

        return smallTetrahedronHeight;
    }

    private double calculateVolumeByInscribedRadius(double inscribedRadius) {
        double faceSquare = calculateFaceSquare(inscribedRadius);
        double height = calculateHeight(inscribedRadius);

        double coefficient = 1.0 / 3.0;

        return coefficient * faceSquare * height;
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

    public double calculateHeight(double inscribedRadius) {
        double coefficient = 3.0 / 2.0;

        return coefficient * inscribedRadius;
    }

    private double calculateInscribedRadius(Tetrahedron tetrahedron) {
        Point baseTopPoint = tetrahedron.getBaseTopPoint();
        Point baseCenterPoint = tetrahedron.getBaseCenterPoint();

        LineCalculator lineCalculator = new LineCalculatorImpl();

        return lineCalculator.calculateDistanceBetweenPoints(baseTopPoint, baseCenterPoint);
    }
}
