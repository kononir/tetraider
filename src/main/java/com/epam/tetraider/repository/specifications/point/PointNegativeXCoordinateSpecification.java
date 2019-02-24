package com.epam.tetraider.repository.specifications.point;

import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.markers.XCoordinateSpecification;

public class PointNegativeXCoordinateSpecification implements XCoordinateSpecification {

    @Override
    public boolean specified(Point point) {
        return (point.getXCord() < 0);
    }
}
