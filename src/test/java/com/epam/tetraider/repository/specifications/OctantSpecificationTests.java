package com.epam.tetraider.repository.specifications;

import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class OctantSpecificationTests {
    private final static NumberedTetrahedron TETRAHEDRON = new NumberedTetrahedron(
            1,
            new Point(1, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 1, 1)
    );

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification() {
        // given
        Specification<Point> xSpecification;
    }
}
