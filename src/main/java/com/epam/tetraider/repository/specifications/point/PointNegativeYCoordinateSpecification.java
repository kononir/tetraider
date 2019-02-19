package com.epam.tetraider.repository.specifications.point;

import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;

public class PointNegativeYCoordinateSpecification implements Specification<Point> {
    @Override
    public boolean specified(Point point) {
        return (point.getYCord() < 0);
    }
}
