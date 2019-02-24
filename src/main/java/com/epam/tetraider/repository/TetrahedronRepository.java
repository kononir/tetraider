package com.epam.tetraider.repository;

import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.repository.interfaces.Repository;
import com.epam.tetraider.repository.interfaces.Specification;

import java.util.*;

public class TetrahedronRepository implements Repository<NumberedTetrahedron> {
    private Map<Integer, NumberedTetrahedron> tetrahedrons = new HashMap<>();

    public Map<Integer, NumberedTetrahedron> getTetrahedrons() {
        return tetrahedrons;
    }

    @Override
    public void add(NumberedTetrahedron tetrahedron) {
        Integer id = tetrahedron.getId();

        if(!tetrahedrons.containsKey(id)) {
            tetrahedrons.put(id, tetrahedron);
        }
    }

    @Override
    public void update(NumberedTetrahedron tetrahedron) {
        Integer id = tetrahedron.getId();

        tetrahedrons.put(id, tetrahedron);
    }

    @Override
    public void remove(NumberedTetrahedron tetrahedron) {
        Integer id = tetrahedron.getId();

        tetrahedrons.remove(id);
    }

    @Override
    public List<NumberedTetrahedron> query(Specification<NumberedTetrahedron> specification) {
        List<NumberedTetrahedron> queriedTetrahedrons = new ArrayList<>();

        for (NumberedTetrahedron tetrahedron: tetrahedrons.values()) {
            if (specification.specified(tetrahedron)) {
                queriedTetrahedrons.add(tetrahedron);
            }
        }

        return queriedTetrahedrons;
    }
}
