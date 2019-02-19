package com.epam.tetraider.repository.specifications.point;

import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;

public class PointNegativeXCoordinateSpecification implements Specification<Point> {

    @Override
    public boolean specified(Point point) {
        return (point.getXCord() < 0);
    }
}
