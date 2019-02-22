package com.epam.tetraider.repository.specifications.point;

import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import org.junit.Assert;
import org.junit.Test;

public class PointPositiveZCoordinateSpecificationTests {
    private static final Point TRUE_POINT = new Point(0, 0, 1);
    private static final Point FALSE_POINT = new Point(0, 0, -10000);

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification() {
        // given
        Specification<Point> specification = new PointPositiveZCoordinateSpecification();

        // when
        boolean actual = specification.specified(TRUE_POINT);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenTetrahedronNotCorrespondToSpecification() {
        // given
        Specification<Point> specification = new PointPositiveZCoordinateSpecification();

        // when
        boolean actual = specification.specified(FALSE_POINT);

        // then
        Assert.assertFalse(actual);
    }
}
