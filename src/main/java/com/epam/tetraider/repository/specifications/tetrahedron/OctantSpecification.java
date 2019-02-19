package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;

import java.util.Arrays;
import java.util.List;

public class OctantSpecification implements Specification<NumberedTetrahedron> {
    private Specification<Point> xSpec;
    private Specification<Point> ySpec;
    private Specification<Point> zSpec;

    public OctantSpecification(Specification<Point> xSpec, Specification<Point> ySpec, Specification<Point> zSpec) {
        this.xSpec = xSpec;
        this.ySpec = ySpec;
        this.zSpec = zSpec;
    }

    @Override
    public boolean specified(NumberedTetrahedron tetrahedron) {
        List<Point> points = Arrays.asList(
                tetrahedron.getTopPoint(),
                tetrahedron.getBaseCenterPoint(),
                tetrahedron.getBaseTopPoint()
        );

        boolean lieInOctant = false;

        for (Point point: points) {
            lieInOctant = xSpec.specified(point) && ySpec.specified(point) && zSpec.specified(point);

            if (!lieInOctant) {
                break;
            }
        }

        return lieInOctant;
    }
}
