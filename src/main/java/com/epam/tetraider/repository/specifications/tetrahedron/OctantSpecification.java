package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.exceptions.SpecificationInvalidParametersException;
import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import com.epam.tetraider.repository.interfaces.markers.XCoordinateSpecification;
import com.epam.tetraider.repository.interfaces.markers.YCoordinateSpecification;
import com.epam.tetraider.repository.interfaces.markers.ZCoordinateSpecification;

import java.util.Arrays;
import java.util.List;

public class OctantSpecification implements Specification<NumberedTetrahedron> {
    private Specification<Point> xSpec;
    private Specification<Point> ySpec;
    private Specification<Point> zSpec;

    public OctantSpecification(XCoordinateSpecification xSpec, YCoordinateSpecification ySpec,
                               ZCoordinateSpecification zSpec)
            throws SpecificationInvalidParametersException {
        if (xSpec == null) {
            throw new SpecificationInvalidParametersException("Invalid parameter: xSpec");
        }

        if (ySpec == null) {
            throw new SpecificationInvalidParametersException("Invalid parameter: ySpec");
        }

        if (zSpec == null) {
            throw new SpecificationInvalidParametersException("Invalid parameter: zSpec");
        }

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
