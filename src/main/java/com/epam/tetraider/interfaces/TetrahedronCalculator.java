package com.epam.tetraider.interfaces;

import com.epam.tetraider.model.Tetrahedron;

public interface TetrahedronCalculator {
    double calculateSurfaceSquare(Tetrahedron tetrahedron);

    double calculateVolume(Tetrahedron tetrahedron);

    double calculateFigureDissectRatio(Tetrahedron tetrahedron);
}
