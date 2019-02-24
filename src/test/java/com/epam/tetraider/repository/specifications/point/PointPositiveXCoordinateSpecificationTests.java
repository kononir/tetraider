package com.epam.tetraider.repository.specifications.point;

import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import org.junit.Assert;
import org.junit.Test;

public class PointPositiveXCoordinateSpecificationTests {
    private static final Point TRUE_POINT = new Point(1, 0, 0);
    private static final Point FALSE_POINT = new Point(-10000, 0, 0);

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification() {
        // given
        Specification<Point> specification = new PointPositiveXCoordinateSpecification();

        // when
        boolean actual = specification.specified(TRUE_POINT);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenTetrahedronNotCorrespondToSpecification() {
        // given
        Specification<Point> specification = new PointPositiveXCoordinateSpecification();

        // when
        boolean actual = specification.specified(FALSE_POINT);

        // then
        Assert.assertFalse(actual);
    }
}
