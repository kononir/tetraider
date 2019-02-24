package com.epam.tetraider.logic.interfaces;

import com.epam.tetraider.model.point.Point;

public interface PointsValidator {
    boolean isValidPoints(Point topPoint, Point baseCenterPoint, Point baseTopPoint);
}
