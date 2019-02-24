package com.epam.tetraider.observer.interfaces;

import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;

public interface Observer<T extends NumberedTetrahedron> {
    void update(T observable);
}
