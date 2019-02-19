package com.epam.tetraider.model;

public class TetrahedronParameters {
    private final double area;
    private final double volume;

    public TetrahedronParameters(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }
}
