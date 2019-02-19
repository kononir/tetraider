package com.epam.tetraider.logic.interfaces;

import com.epam.tetraider.model.Tetrahedron;

public interface TetrahedronCalculator {
    double calculateSurfaceArea(Tetrahedron tetrahedron);

    double calculateVolume(Tetrahedron tetrahedron);

    double calculateFigureDissectRatio(Tetrahedron tetrahedron);

    boolean isBaseLiesAtCoordinatePlane(Tetrahedron tetrahedron);
}
