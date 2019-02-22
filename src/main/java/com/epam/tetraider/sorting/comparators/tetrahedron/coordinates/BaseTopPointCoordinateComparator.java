package com.epam.tetraider.sorting.comparators.tetrahedron.coordinates;

import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;

import java.util.Comparator;

public class BaseTopPointCoordinateComparator implements Comparator<NumberedTetrahedron> {
    private Comparator<Point> pointCordComparator;

    public BaseTopPointCoordinateComparator(Comparator<Point> pointCordComparator) {
        this.pointCordComparator = pointCordComparator;
    }

    @Override
    public int compare(NumberedTetrahedron o1, NumberedTetrahedron o2) {
        Point point1 = o1.getBaseTopPoint();
        Point point2 = o2.getBaseTopPoint();

        return pointCordComparator.compare(point1, point2);
    }
}
