package com.epam.tetraider.logic.interfaces;

import com.epam.tetraider.model.Point;

public interface PointsValidator {
    boolean isValidPoints(Point topPoint, Point baseCenterPoint, Point baseTopPoint);
}
