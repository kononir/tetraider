package com.epam.tetraider.repository.specifications.point;

import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.markers.YCoordinateSpecification;

public class PointNegativeYCoordinateSpecification implements YCoordinateSpecification {
    @Override
    public boolean specified(Point point) {
        return (point.getYCord() < 0);
    }
}
