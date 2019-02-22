package com.epam.tetraider.sorting.comparators.tetrahedron.coordinates;

import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;

import java.util.Comparator;

public class TopPointCoordinateComparator implements Comparator<NumberedTetrahedron> {
    private Comparator<Point> pointCordComparator;

    public TopPointCoordinateComparator(Comparator<Point> pointCordComparator) {
        this.pointCordComparator = pointCordComparator;
    }

    @Override
    public int compare(NumberedTetrahedron o1, NumberedTetrahedron o2) {
        Point point1 = o1.getTopPoint();
        Point point2 = o2.getTopPoint();

        return pointCordComparator.compare(point1, point2);
    }
}
