package com.epam.tetraider.repository.interfaces;

import com.epam.tetraider.model.NumberedTetrahedron;

import java.util.List;

public interface Repository<T extends NumberedTetrahedron> {
    void add(T tetrahedron);
    void update(T tetrahedron);
    void remove(T tetrahedron);

    List<T> query(Specification<T> specification);
}
