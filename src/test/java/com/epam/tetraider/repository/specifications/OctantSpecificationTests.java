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
    private final static NumberedTetrahedron TETRAHEDRON = new NumberedTetrahedron(
            1,
            new Point(1, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 1, 1)
    );

    private final static Point SPECIFIED_POINT = new Point(1, 1, 1);

    private final static int THREE_TIMES = 3;

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification() {
        // given
        Specification<Point> xSpecification = mock(PointPositiveXCoordinateSpecification.class);
        when(xSpecification.specified(SPECIFIED_POINT)).thenReturn(true);

        Specification<Point> ySpecification = mock(PointPositiveYCoordinateSpecification.class);
        when(ySpecification.specified(SPECIFIED_POINT)).thenReturn(true);

        Specification<Point> zSpecification = mock(PointPositiveZCoordinateSpecification.class);
        when(zSpecification.specified(SPECIFIED_POINT)).thenReturn(true);

        Specification<NumberedTetrahedron> octantSpecification = new OctantSpecification(
                xSpecification,
                ySpecification,
                zSpecification
        );

        // when
        boolean actual = octantSpecification.specified(TETRAHEDRON);

        // then
        Assert.assertTrue(actual);

        verify(xSpecification, times(THREE_TIMES)).specified(SPECIFIED_POINT);
        verify(ySpecification, times(THREE_TIMES)).specified(SPECIFIED_POINT);
        verify(zSpecification, times(THREE_TIMES)).specified(SPECIFIED_POINT);
    }
}
