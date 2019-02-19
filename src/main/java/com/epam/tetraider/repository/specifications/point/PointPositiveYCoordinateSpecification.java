package com.epam.tetraider.repository.specifications.tetrahedron.pointspecifications;

import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;

public class PointPositiveYCoordinateSpecification implements Specification<Point> {
    @Override
    public boolean specified(Point point) {
        return (point.getYCord() >= 0);
    }
}
