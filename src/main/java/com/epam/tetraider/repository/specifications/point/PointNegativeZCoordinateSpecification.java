package com.epam.tetraider.repository.specifications.point;

import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.markers.ZCoordinateSpecification;

public class PointNegativeZCoordinateSpecification implements ZCoordinateSpecification {
    @Override
    public boolean specified(Point point) {
        return (point.getZCord() < 0);
    }
}
