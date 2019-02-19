package com.epam.tetraider.model;

public class Tetrahedron {
    private Point topPoint;
    private Point baseCenterPoint;
    private Point baseTopPoint;

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

    public void setTopPoint(Point topPoint) {
        this.topPoint = topPoint;
    }

    public void setBaseCenterPoint(Point baseCenterPoint) {
        this.baseCenterPoint = baseCenterPoint;
    }

    public void setBaseTopPoint(Point baseTopPoint) {
        this.baseTopPoint = baseTopPoint;
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

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Tetrahedron tetrahedron = (Tetrahedron) obj;

        Point topPointOther = tetrahedron.topPoint;
        Point baseCenterPointOther = tetrahedron.baseCenterPoint;
        Point baseTopPointOther = tetrahedron.baseTopPoint;

        return topPoint != null && topPoint.equals(topPointOther)
                && baseCenterPoint != null && baseCenterPoint.equals(baseCenterPointOther)
                && baseTopPoint != null && baseTopPoint.equals(baseTopPointOther);
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
