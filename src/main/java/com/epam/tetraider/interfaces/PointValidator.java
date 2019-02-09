package com.epam.tetraider.interfaces;

import com.epam.tetraider.model.Point;

public interface PointValidator {
    boolean isValidPoints(Point topPoint, Point baseCenterPoint, Point baseTopPoint);
}
