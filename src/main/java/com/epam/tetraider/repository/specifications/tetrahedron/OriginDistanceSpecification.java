package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.exceptions.SpecificationInvalidParametersException;
import com.epam.tetraider.logic.interfaces.LineCalculator;
import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.model.point.OriginPoint;
import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.Specification;

public class OriginDistanceSpecification implements Specification<NumberedTetrahedron> {
    private double desiredLowerDistance;
    private double desiredUpperDistance;
    private LineCalculator calculator;

    public OriginDistanceSpecification(double desiredLowerDistance, double desiredUpperDistance,
                                       LineCalculator calculator)
            throws SpecificationInvalidParametersException {
        if (calculator == null) {
            throw new SpecificationInvalidParametersException("Invalid parameter: calculator!");
        }

        this.desiredLowerDistance = desiredLowerDistance;
        this.desiredUpperDistance = desiredUpperDistance;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(NumberedTetrahedron tetrahedron) {
        Point topPoint = tetrahedron.getTopPoint();
        Point baseCenterPoint = tetrahedron.getBaseCenterPoint();

        Point tetrahedronCenterPoint = calculator.findCenterOfHorizontalLine(topPoint, baseCenterPoint);
        Point originPoint = OriginPoint.getInstance();

        double distance = calculator.calculateDistanceBetweenPoints(tetrahedronCenterPoint, originPoint);

        return (distance > desiredLowerDistance && distance < desiredUpperDistance);
    }
}
