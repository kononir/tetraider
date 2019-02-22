package com.epam.tetraider.repository.specifications;

import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import com.epam.tetraider.repository.specifications.point.PointPositiveXCoordinateSpecification;
import com.epam.tetraider.repository.specifications.point.PointPositiveYCoordinateSpecification;
import com.epam.tetraider.repository.specifications.point.PointPositiveZCoordinateSpecification;
import com.epam.tetraider.repository.specifications.tetrahedron.OctantSpecification;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OctantSpecificationTests {
    private final static NumberedTetrahedron TRUE_TETRAHEDRON = new NumberedTetrahedron(
            1,
            new Point(1, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 1, 1)
    );

    private final static NumberedTetrahedron FALSE_TETRAHEDRON = new NumberedTetrahedron(
            1,
            new Point(-1, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 1, 1)
    );

    private final static Point SPECIFIED_TRUE_POINT = new Point(1, 1, 1);
    private final static Point SPECIFIED_FALSE_POINT = new Point(-1, 1, 1);

    private final static int THREE_TIMES = 3;

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification() {
        // given
        Specification<Point> xSpecification = mock(PointPositiveXCoordinateSpecification.class);
        when(xSpecification.specified(SPECIFIED_TRUE_POINT)).thenReturn(true);

        Specification<Point> ySpecification = mock(PointPositiveYCoordinateSpecification.class);
        when(ySpecification.specified(SPECIFIED_TRUE_POINT)).thenReturn(true);

        Specification<Point> zSpecification = mock(PointPositiveZCoordinateSpecification.class);
        when(zSpecification.specified(SPECIFIED_TRUE_POINT)).thenReturn(true);

        Specification<NumberedTetrahedron> octantSpecification = new OctantSpecification(
                xSpecification,
                ySpecification,
                zSpecification
        );

        // when
        boolean actual = octantSpecification.specified(TRUE_TETRAHEDRON);

        // then
        Assert.assertTrue(actual);

        verify(xSpecification, times(THREE_TIMES)).specified(SPECIFIED_TRUE_POINT);
        verify(ySpecification, times(THREE_TIMES)).specified(SPECIFIED_TRUE_POINT);
        verify(zSpecification, times(THREE_TIMES)).specified(SPECIFIED_TRUE_POINT);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenTetrahedronNotCorrespondToSpecification() {
        // given
        Specification<Point> xSpecification = mock(PointPositiveXCoordinateSpecification.class);
        when(xSpecification.specified(SPECIFIED_FALSE_POINT)).thenReturn(false);

        Specification<Point> ySpecification = mock(PointPositiveYCoordinateSpecification.class);

        Specification<Point> zSpecification = mock(PointPositiveZCoordinateSpecification.class);

        Specification<NumberedTetrahedron> octantSpecification = new OctantSpecification(
                xSpecification,
                ySpecification,
                zSpecification
        );

        // when
        boolean actual = octantSpecification.specified(FALSE_TETRAHEDRON);

        // then
        Assert.assertFalse(actual);

        verify(xSpecification, atLeastOnce()).specified(SPECIFIED_FALSE_POINT);
        verify(ySpecification, never()).specified(SPECIFIED_FALSE_POINT);
        verify(zSpecification, never()).specified(SPECIFIED_FALSE_POINT);
    }
}
