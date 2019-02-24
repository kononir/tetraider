package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.exceptions.SpecificationInvalidParametersException;
import com.epam.tetraider.logic.TetrahedronCalculatorImpl;
import com.epam.tetraider.logic.interfaces.TetrahedronCalculator;
import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

public class VolumeSpecificationTests {
    private static final NumberedTetrahedron TETRAHEDRON = new NumberedTetrahedron(
            1,
            new Point(0, 0, 6),
            new Point(0, 0, 0),
            new Point(2, 0, 0)
    );

    private static final double LOWER_VOLUME = 5;
    private static final double UPPER_VOLUME = 6;
    private static final double TRUE_VOLUME = 5.19;
    private static final double FALSE_VOLUME = 100000;

    private static final TetrahedronCalculator NULL_CALCULATOR = null;

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification()
            throws SpecificationInvalidParametersException {
        // given
        TetrahedronCalculator calculator = mock(TetrahedronCalculatorImpl.class);
        when(calculator.calculateVolume(TETRAHEDRON)).thenReturn(TRUE_VOLUME);

        Specification<NumberedTetrahedron> specification = new VolumeSpecification(LOWER_VOLUME, UPPER_VOLUME, calculator);

        // when
        boolean actual = specification.specified(TETRAHEDRON);

        // then
        Assert.assertTrue(actual);

        verify(calculator, atLeastOnce()).calculateVolume(TETRAHEDRON);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenTetrahedronNotCorrespondToSpecification()
            throws SpecificationInvalidParametersException {
        // given
        TetrahedronCalculator calculator = mock(TetrahedronCalculatorImpl.class);
        when(calculator.calculateVolume(TETRAHEDRON)).thenReturn(FALSE_VOLUME);

        Specification<NumberedTetrahedron> specification = new VolumeSpecification(LOWER_VOLUME, UPPER_VOLUME, calculator);

        // when
        boolean actual = specification.specified(TETRAHEDRON);

        // then
        Assert.assertFalse(actual);

        verify(calculator, atLeastOnce()).calculateVolume(TETRAHEDRON);
    }

    @Test (expected = SpecificationInvalidParametersException.class)
    public void testSpecifiedShouldThrowExceptionWhenGivenNull()
            throws SpecificationInvalidParametersException {
        // given

        // when
        new VolumeSpecification(LOWER_VOLUME, UPPER_VOLUME, NULL_CALCULATOR);

        // then
        Assert.fail();
    }
}
