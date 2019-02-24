package com.epam.tetraider.sorting.comparators.point;

import com.epam.tetraider.model.point.Point;

import java.util.Comparator;

public class PointXComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        double xCord1 = o1.getXCord();
        double xCord2 = o2.getXCord();

        return Double.compare(xCord1, xCord2);
    }
}
