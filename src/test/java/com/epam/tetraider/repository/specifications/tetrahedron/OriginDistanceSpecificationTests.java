package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.exceptions.SpecificationInvalidParametersException;
import com.epam.tetraider.logic.LineCalculatorImpl;
import com.epam.tetraider.logic.interfaces.LineCalculator;
import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OriginDistanceSpecificationTests {
    private static final Point FIRST_POINT = new Point(0, 0, 6);
    private static final Point SECOND_POINT = new Point(0, 0, 0);

    private static final Point CENTER_POINT = new Point(0, 0, 3);
    private static final Point ORIGIN_POINT = new Point(0, 0, 0);

    private static final NumberedTetrahedron TETRAHEDRON = new NumberedTetrahedron(
            1,
            FIRST_POINT,
            SECOND_POINT,
            new Point(2, 0, 0)
    );

    private static final double LOWER_DISTANCE = 2;
    private static final double UPPER_DISTANCE = 4;
    private static final double TRUE_DISTANCE = 3;
    private static final double FALSE_DISTANCE = 100000;

    private static final LineCalculator NULL_CALCULATOR = null;

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification()
            throws SpecificationInvalidParametersException {
        // given
        LineCalculator calculator = mock(LineCalculatorImpl.class);
        when(calculator.findCenterOfHorizontalLine(FIRST_POINT, SECOND_POINT)).thenReturn(CENTER_POINT);
        when(calculator.calculateDistanceBetweenPoints(CENTER_POINT, ORIGIN_POINT)).thenReturn(TRUE_DISTANCE);

        Specification<NumberedTetrahedron> specification = new OriginDistanceSpecification(
                LOWER_DISTANCE,
                UPPER_DISTANCE,
                calculator
        );

        // when
        boolean actual = specification.specified(TETRAHEDRON);

        // then
        Assert.assertTrue(actual);

        verify(calculator, atLeastOnce()).findCenterOfHorizontalLine(FIRST_POINT, SECOND_POINT);
        verify(calculator, atLeastOnce()).calculateDistanceBetweenPoints(CENTER_POINT, ORIGIN_POINT);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenTetrahedronNotCorrespondToSpecification()
            throws SpecificationInvalidParametersException {
        // given
        LineCalculator calculator = mock(LineCalculatorImpl.class);
        when(calculator.findCenterOfHorizontalLine(FIRST_POINT, SECOND_POINT)).thenReturn(CENTER_POINT);
        when(calculator.calculateDistanceBetweenPoints(CENTER_POINT, ORIGIN_POINT)).thenReturn(FALSE_DISTANCE);

        Specification<NumberedTetrahedron> specification = new OriginDistanceSpecification(
                LOWER_DISTANCE,
                UPPER_DISTANCE,
                calculator
        );

        // when
        boolean actual = specification.specified(TETRAHEDRON);

        // then
        Assert.assertFalse(actual);

        verify(calculator, atLeastOnce()).findCenterOfHorizontalLine(FIRST_POINT, SECOND_POINT);
        verify(calculator, atLeastOnce()).calculateDistanceBetweenPoints(CENTER_POINT, ORIGIN_POINT);
    }

    @Test (expected = SpecificationInvalidParametersException.class)
    public void testSpecifiedShouldThrowExceptionWhenGivenNull()
            throws SpecificationInvalidParametersException {
        // given

        // when
        new OriginDistanceSpecification(LOWER_DISTANCE, UPPER_DISTANCE, NULL_CALCULATOR);

        // then
        Assert.fail();
    }
}
