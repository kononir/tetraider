package com.epam.tetraider.sorting.comparators.point;

import com.epam.tetraider.model.point.Point;

import java.util.Comparator;

public class PointZComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        double zCord1 = o1.getZCord();
        double zCord2 = o2.getZCord();
        
        return Double.compare(zCord1, zCord2);
    }
}
