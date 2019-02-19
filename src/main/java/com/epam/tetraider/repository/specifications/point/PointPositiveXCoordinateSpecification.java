package com.epam.tetraider.repository.specifications.tetrahedron.pointspecifications;

import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;

public class PointPositiveXCoordinateSpecification implements Specification<Point> {

    @Override
    public boolean specified(Point point) {
        return (point.getXCord() >= 0);
    }
}
