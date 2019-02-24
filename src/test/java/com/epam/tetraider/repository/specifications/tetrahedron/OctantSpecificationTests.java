package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.exceptions.SpecificationInvalidParametersException;
import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import com.epam.tetraider.repository.interfaces.markers.XCoordinateSpecification;
import com.epam.tetraider.repository.interfaces.markers.YCoordinateSpecification;
import com.epam.tetraider.repository.interfaces.markers.ZCoordinateSpecification;
import com.epam.tetraider.repository.specifications.point.PointPositiveXCoordinateSpecification;
import com.epam.tetraider.repository.specifications.point.PointPositiveYCoordinateSpecification;
import com.epam.tetraider.repository.specifications.point.PointPositiveZCoordinateSpecification;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OctantSpecificationTests {
    private static final NumberedTetrahedron TRUE_TETRAHEDRON = new NumberedTetrahedron(
            1,
            new Point(1, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 1, 1)
    );

    private static final NumberedTetrahedron FALSE_TETRAHEDRON = new NumberedTetrahedron(
            1,
            new Point(-1, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 1, 1)
    );

    private static final Point SPECIFIED_TRUE_POINT = new Point(1, 1, 1);
    private static final Point SPECIFIED_FALSE_POINT = new Point(-1, 1, 1);

    private static final XCoordinateSpecification NOT_NULL_X_SPEC = new PointPositiveXCoordinateSpecification();
    private static final YCoordinateSpecification NOT_NULL_Y_SPEC = new PointPositiveYCoordinateSpecification();
    private static final ZCoordinateSpecification NOT_NULL_Z_SPEC = new PointPositiveZCoordinateSpecification();

    private static final XCoordinateSpecification NULL_X_SPEC = null;
    private static final YCoordinateSpecification NULL_Y_SPEC = null;
    private static final ZCoordinateSpecification NULL_Z_SPEC = null;

    private static final int THREE_TIMES = 3;

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification() throws SpecificationInvalidParametersException {
        // given
        XCoordinateSpecification xSpecification = mock(PointPositiveXCoordinateSpecification.class);
        when(xSpecification.specified(SPECIFIED_TRUE_POINT)).thenReturn(true);

        YCoordinateSpecification ySpecification = mock(PointPositiveYCoordinateSpecification.class);
        when(ySpecification.specified(SPECIFIED_TRUE_POINT)).thenReturn(true);

        ZCoordinateSpecification zSpecification = mock(PointPositiveZCoordinateSpecification.class);
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
    public void testSpecifiedShouldReturnFalseWhenTetrahedronNotCorrespondToSpecification() throws SpecificationInvalidParametersException {
        // given
        XCoordinateSpecification xSpecification = mock(PointPositiveXCoordinateSpecification.class);
        when(xSpecification.specified(SPECIFIED_FALSE_POINT)).thenReturn(false);

        YCoordinateSpecification ySpecification = mock(PointPositiveYCoordinateSpecification.class);

        ZCoordinateSpecification zSpecification = mock(PointPositiveZCoordinateSpecification.class);

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

    @Test (expected = SpecificationInvalidParametersException.class)
    public void testSpecifiedShouldThrowExceptionWhenGivenNullXSpec()
            throws SpecificationInvalidParametersException {
        // given

        // when
        new OctantSpecification(NULL_X_SPEC, NOT_NULL_Y_SPEC, NOT_NULL_Z_SPEC);

        // then
        Assert.fail();
    }

    @Test (expected = SpecificationInvalidParametersException.class)
    public void testSpecifiedShouldThrowExceptionWhenGivenNullYSpec()
            throws SpecificationInvalidParametersException {
        // given

        // when
        new OctantSpecification(NOT_NULL_X_SPEC, NULL_Y_SPEC, NOT_NULL_Z_SPEC);

        // then
        Assert.fail();
    }

    @Test (expected = SpecificationInvalidParametersException.class)
    public void testSpecifiedShouldThrowExceptionWhenGivenNullZSpec()
            throws SpecificationInvalidParametersException {
        // given

        // when
        new OctantSpecification(NOT_NULL_X_SPEC, NOT_NULL_Y_SPEC, NULL_Z_SPEC);

        // then
        Assert.fail();
    }
}
