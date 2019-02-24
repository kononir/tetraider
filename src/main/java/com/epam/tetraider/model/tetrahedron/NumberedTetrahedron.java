package com.epam.tetraider.model.tetrahedron;

import com.epam.tetraider.model.point.Point;

public class NumberedTetrahedron extends Tetrahedron {
    private final Integer id;

    public NumberedTetrahedron(int id, Point topPoint, Point baseCenterPoint, Point baseTopPoint) {
        super(topPoint, baseCenterPoint, baseTopPoint);

        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString() + " Tetrahedron id: " + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        NumberedTetrahedron tetrahedron = (NumberedTetrahedron) obj;

        Integer otherID = tetrahedron.getId();

        Point topPointOther = tetrahedron.getTopPoint();
        Point baseCenterPointOther = tetrahedron.getBaseCenterPoint();
        Point baseTopPointOther = tetrahedron.getBaseTopPoint();

        Point topPoint = this.getTopPoint();
        Point baseCenterPoint = this.getBaseCenterPoint();
        Point baseTopPoint = this.getBaseTopPoint();

        return id != null && id.equals(otherID)
                && topPoint != null && topPoint.equals(topPointOther)
                && baseCenterPoint != null && baseCenterPoint.equals(baseCenterPointOther)
                && baseTopPoint != null && baseTopPoint.equals(baseTopPointOther);
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        Point topPoint = this.getTopPoint();
        Point baseCenterPoint = this.getBaseCenterPoint();
        Point baseTopPoint = this.getBaseTopPoint();

        final int idHash = ((id == null) ? 0: id);
        final int topPointHash = ((topPoint == null) ? 0: topPoint.hashCode());
        final int baseCenterPointHash = ((baseCenterPoint == null) ? 0: baseCenterPoint.hashCode());
        final int baseTopPointHash = ((baseTopPoint == null) ? 0: baseTopPoint.hashCode());

        return (prime * idHash + topPointHash + baseCenterPointHash + baseTopPointHash);
    }
}
