package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.logic.interfaces.TetrahedronCalculator;
import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.repository.interfaces.Specification;

public class AreaSpecification implements Specification<NumberedTetrahedron> {
    private double desiredLowerArea;
    private double desiredUpperArea;
    private TetrahedronCalculator calculator;

    public AreaSpecification(double desiredLowerArea, double desiredUpperArea, TetrahedronCalculator calculator) {
        this.desiredLowerArea = desiredLowerArea;
        this.desiredUpperArea = desiredUpperArea;
    }

    @Override
    public boolean specified(NumberedTetrahedron tetrahedron) {
        double area = calculator.calculateSurfaceArea(tetrahedron);

        return (area >= desiredLowerArea && area <= desiredUpperArea);
    }
}
