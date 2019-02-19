package com.epam.tetraider.repository.specifications.tetrahedron.pointspecifications;

import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;

public class PointNegativeZCoordinateSpecification implements Specification<Point> {
    @Override
    public boolean specified(Point point) {
        return (point.getZCord() < 0);
    }
}
