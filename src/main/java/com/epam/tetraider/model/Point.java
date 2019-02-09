package com.epam.tetraider.model;

public class Point {
    private final double xCord;
    private final double yCord;
    private final double zCord;

    public Point(double xCord, double yCord, double zCord) {
        this.xCord = xCord;
        this.yCord = yCord;
        this.zCord = zCord;
    }

    public double getXCord() {
        return xCord;
    }

    public double getYCord() {
        return yCord;
    }

    public double getZCord() {
        return zCord;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@x: " + xCord + ", y: " + yCord + ", z:" + zCord;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Point point = (Point) obj;

        double xCordOther = point.xCord;
        double delta = 0.01;

        if (xCordOther - xCord > delta) {
            return false;
        }

        double yCordOther = point.yCord;

        if (yCordOther - yCord > delta) {
            return false;
        }

        double zCordOther = point.zCord;

        if (zCordOther - zCord > delta) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        return (prime * (int) xCord + (int) yCord + (int) zCord);
    }
}
