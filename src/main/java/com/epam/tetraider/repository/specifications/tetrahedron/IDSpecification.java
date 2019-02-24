package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.exceptions.SpecificationInvalidParametersException;
import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.repository.interfaces.Specification;

public class IDSpecification implements Specification<NumberedTetrahedron> {
    private Integer desiredId;

    public IDSpecification(Integer desiredId) throws SpecificationInvalidParametersException {
        if (desiredId == null) {
            throw new SpecificationInvalidParametersException("Invalid parameter: desiredID!");
        }

        this.desiredId = desiredId;
    }

    @Override
    public boolean specified(NumberedTetrahedron tetrahedron) {
        Integer id = tetrahedron.getId();

        return id.equals(desiredId);
    }
}
