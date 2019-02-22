package com.epam.tetraider.sorting.comparators.point;

import com.epam.tetraider.model.Point;

import java.util.Comparator;

public class PointYComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        double yCord1 = o1.getYCord();
        double yCord2 = o2.getYCord();
        
        return Double.compare(yCord1, yCord2);
    }
}
