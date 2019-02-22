package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.logic.interfaces.LineCalculator;
import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;

public class OriginDistanceSpecification implements Specification<NumberedTetrahedron> {
    private double desiredLowerDistance;
    private double desiredUpperDistance;
    private LineCalculator calculator;

    public OriginDistanceSpecification(double desiredLowerDistance, double desiredUpperDistance,
                                       LineCalculator calculator) {
        this.desiredLowerDistance = desiredLowerDistance;
        this.desiredUpperDistance = desiredUpperDistance;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(NumberedTetrahedron tetrahedron) {
        Point topPoint = tetrahedron.getTopPoint();
        Point baseCenterPoint = tetrahedron.getBaseCenterPoint();

        Point tetrahedronCenterPoint = calculator.findCenterOfHorizontalLine(topPoint, baseCenterPoint);

        double zeroCord = 0;
        Point originPoint = new Point(zeroCord, zeroCord, zeroCord);

        double distance = calculator.calculateDistanceBetweenPoints(tetrahedronCenterPoint, originPoint);

        return (distance > desiredLowerDistance && distance < desiredUpperDistance);
    }
}
