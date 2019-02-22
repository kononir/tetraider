package com.epam.tetraider.logic.interfaces;

import com.epam.tetraider.model.Point;

public interface LineCalculator {
    double calculateDistanceBetweenPoints(Point firstPoint, Point secondPoint);

    Point findCenterOfHorizontalLine(Point firstPoint, Point secondPoint);
}
