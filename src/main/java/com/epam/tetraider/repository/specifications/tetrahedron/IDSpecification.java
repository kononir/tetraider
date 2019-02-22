package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.repository.interfaces.Specification;

public class IDSpecification implements Specification<NumberedTetrahedron> {
    private Integer desiredId;

    public IDSpecification(Integer desiredId) {
        this.desiredId = desiredId;
    }

    @Override
    public boolean specified(NumberedTetrahedron tetrahedron) {
        Integer id = tetrahedron.getId();

        return id.equals(desiredId);
    }
}
