package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.exceptions.SpecificationInvalidParametersException;
import com.epam.tetraider.logic.interfaces.TetrahedronCalculator;
import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.repository.interfaces.Specification;

public class VolumeSpecification implements Specification<NumberedTetrahedron> {
    private double desiredLowerVolume;
    private double desiredUpperVolume;
    private TetrahedronCalculator calculator;

    public VolumeSpecification(double desiredLowerVolume, double desiredUpperVolume, TetrahedronCalculator calculator)
            throws SpecificationInvalidParametersException {
        if (calculator == null) {
            throw new SpecificationInvalidParametersException("Invalid parameter: calculator");
        }

        this.desiredLowerVolume = desiredLowerVolume;
        this.desiredUpperVolume = desiredUpperVolume;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(NumberedTetrahedron tetrahedron) {
        double volume = calculator.calculateVolume(tetrahedron);

        return (volume >= desiredLowerVolume && volume <= desiredUpperVolume);
    }
}
