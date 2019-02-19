package com.epam.tetraider.observer;

import com.epam.tetraider.logic.interfaces.TetrahedronCalculator;
import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.TetrahedronParameters;
import com.epam.tetraider.observer.interfaces.Observer;

import java.util.HashMap;
import java.util.Map;

public class TetrahedronObserver implements Observer<NumberedTetrahedron> {
    private static TetrahedronObserver instance;

    private TetrahedronCalculator tetrahedronCalculator;
    private Map<Integer, TetrahedronParameters> parametersMap = new HashMap<>();

    private TetrahedronObserver(TetrahedronCalculator tetrahedronCalculator) {
        this.tetrahedronCalculator = tetrahedronCalculator;
    }

    public static TetrahedronObserver getInstance(TetrahedronCalculator tetrahedronCalculator) {
        if (instance == null) {
            instance = new TetrahedronObserver(tetrahedronCalculator);
        }

        return instance;
    }

    @Override
    public void update(NumberedTetrahedron observable) {
        double surfaceArea = tetrahedronCalculator.calculateSurfaceArea(observable);
        double volume = tetrahedronCalculator.calculateVolume(observable);

        Integer id = observable.getId();

        parametersMap.put(id, new TetrahedronParameters(surfaceArea, volume));
    }

    public TetrahedronParameters getTetrahedronParameters(Integer id) {
        return parametersMap.get(id);
    }
}
