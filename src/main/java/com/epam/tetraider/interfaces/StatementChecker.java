package com.epam.tetraider.interfaces;

import com.epam.tetraider.model.Tetrahedron;

public interface StatementChecker {
    boolean isTetrahedron(Object obj);

    boolean isBaseLiesAtCoordinatePlane(Tetrahedron tetrahedron);
}
