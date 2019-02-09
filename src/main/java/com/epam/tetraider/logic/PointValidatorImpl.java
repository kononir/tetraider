package com.epam.tetraider.logic;

import com.epam.tetraider.interfaces.PointValidator;
import com.epam.tetraider.model.Point;

public class PointValidatorImpl implements PointValidator {
    @Override
    public boolean isValidPoints(Point topPoint, Point baseCenterPoint, Point baseTopPoint) {
        return false;
    }
}
