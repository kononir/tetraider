package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.exceptions.SpecificationInvalidParametersException;
import com.epam.tetraider.logic.TetrahedronCalculatorImpl;
import com.epam.tetraider.logic.TetrahedronCalculatorImplTests;
import com.epam.tetraider.logic.interfaces.TetrahedronCalculator;
import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class AreaSpecificationTests {
    private static final NumberedTetrahedron TETRAHEDRON = new NumberedTetrahedron(
            1,
            new Point(0, 0, 6),
            new Point(0, 0, 0),
            new Point(2, 0, 0)
    );

    private static final double LOWER_AREA = 20;
    private static final double UPPER_AREA = 21;
    private static final double TRUE_AREA = 20.78;
    private static final double FALSE_AREA = 100000;

    private static final TetrahedronCalculator NULL_CALCULATOR = null;

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification()
            throws SpecificationInvalidParametersException {
        // given
        TetrahedronCalculator calculator = mock(TetrahedronCalculatorImpl.class);
        when(calculator.calculateSurfaceArea(TETRAHEDRON)).thenReturn(TRUE_AREA);

        Specification<NumberedTetrahedron> specification = new AreaSpecification(LOWER_AREA, UPPER_AREA, calculator);

        // when
        boolean actual = specification.specified(TETRAHEDRON);

        // then
        Assert.assertTrue(actual);

        verify(calculator, atLeastOnce()).calculateSurfaceArea(TETRAHEDRON);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenTetrahedronNotCorrespondToSpecification()
            throws SpecificationInvalidParametersException {
        // given
        TetrahedronCalculator calculator = mock(TetrahedronCalculatorImpl.class);
        when(calculator.calculateSurfaceArea(TETRAHEDRON)).thenReturn(FALSE_AREA);

        Specification<NumberedTetrahedron> specification = new AreaSpecification(LOWER_AREA, UPPER_AREA, calculator);

        // when
        boolean actual = specification.specified(TETRAHEDRON);

        // then
        Assert.assertFalse(actual);

        verify(calculator, atLeastOnce()).calculateSurfaceArea(TETRAHEDRON);
    }

    @Test (expected = SpecificationInvalidParametersException.class)
    public void testSpecifiedShouldThrowExceptionWhenGivenNull()
            throws SpecificationInvalidParametersException {
        // given

        // when
        new AreaSpecification(LOWER_AREA, UPPER_AREA, NULL_CALCULATOR);

        // then
        Assert.fail();
    }
}
