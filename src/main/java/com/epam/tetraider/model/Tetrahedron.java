package com.epam.tetraider.model;

public class Tetrahedron {
    private final Point topPoint;
    private final Point baseCenterPoint;
    private final Point baseTopPoint;

    public Tetrahedron(Point topPoint, Point baseCenterPoint, Point baseTopPoint) {
        this.topPoint = topPoint;
        this.baseCenterPoint = baseCenterPoint;
        this.baseTopPoint = baseTopPoint;
    }

    public Point getTopPoint() {
        return topPoint;
    }

    public Point getBaseCenterPoint() {
        return baseCenterPoint;
    }

    public Point getBaseTopPoint() {
        return baseTopPoint;
    }

    @Override
    public String toString() {
        double topPointXCord = topPoint.getXCord();
        double topPointYCord = topPoint.getYCord();
        double topPointZCord = topPoint.getZCord();

        double baseTopPointXCord = baseTopPoint.getXCord();
        double baseTopPointYCord = baseTopPoint.getYCord();
        double baseTopPointZCord = baseTopPoint.getZCord();

        double baseCenterPointXCord = baseCenterPoint.getXCord();
        double baseCenterPointYCord = baseCenterPoint.getYCord();
        double baseCenterPointZCord = baseCenterPoint.getZCord();

        return getClass().getName() + "@Top Point(" + topPointXCord + ", " + topPointYCord + ", " + topPointZCord + "), Base Top Point("
                + baseTopPointXCord + ", " + baseTopPointYCord + ", " + baseTopPointZCord + "), Base Center Point("
                + baseCenterPointXCord + ", " + baseCenterPointYCord + ", " + baseCenterPointZCord + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Tetrahedron tetrahedron = (Tetrahedron) obj;
        Point topPointOther = tetrahedron.topPoint;

        if (topPoint == null || !topPoint.equals(topPointOther)) {
            return false;
        }

        Point baseCenterPointOther = tetrahedron.baseCenterPoint;

        if (baseCenterPoint == null || !baseCenterPoint.equals(baseCenterPointOther)) {
            return false;
        }

        Point baseTopPointOther = tetrahedron.baseTopPoint;

        if (baseTopPoint == null || !baseTopPoint.equals(baseTopPointOther)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        final int topPointHash = ((topPoint == null) ? 0: topPoint.hashCode());
        final int baseCenterPointHash = ((baseCenterPoint == null) ? 0: baseCenterPoint.hashCode());
        final int baseTopPointHash = ((baseTopPoint == null) ? 0: baseTopPoint.hashCode());

        return (prime * topPointHash + baseCenterPointHash + baseTopPointHash);
    }
}
