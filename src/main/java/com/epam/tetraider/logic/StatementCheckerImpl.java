package com.epam.tetraider.logic;

import com.epam.tetraider.interfaces.StatementChecker;
import com.epam.tetraider.model.Tetrahedron;

public class StatementCheckerImpl implements StatementChecker {
    @Override
    public boolean isTetrahedron(Object obj) {
        return false;
    }

    @Override
    public boolean isBaseLiesAtCoordinatePlane(Tetrahedron tetrahedron) {
        return false;
    }
}
