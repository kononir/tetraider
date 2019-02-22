package com.epam.tetraider.repository.specifications;

import com.epam.tetraider.logic.TetrahedronCalculatorImpl;
import com.epam.tetraider.logic.interfaces.TetrahedronCalculator;
import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import com.epam.tetraider.repository.specifications.tetrahedron.AreaSpecification;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification() {
        // given
        TetrahedronCalculator calculator = mock(TetrahedronCalculatorImpl.class);
        when(calculator.calculateSurfaceArea(TETRAHEDRON)).thenReturn(TRUE_AREA);

        Specification<NumberedTetrahedron> specification = new AreaSpecification(LOWER_AREA, UPPER_AREA, calculator);

        // when
        boolean actual = specification.specified(TETRAHEDRON);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenTetrahedronNotCorrespondToSpecification() {
        // given
        TetrahedronCalculator calculator = mock(TetrahedronCalculatorImpl.class);
        when(calculator.calculateSurfaceArea(TETRAHEDRON)).thenReturn(FALSE_AREA);

        Specification<NumberedTetrahedron> specification = new AreaSpecification(LOWER_AREA, UPPER_AREA, calculator);

        // when
        boolean actual = specification.specified(TETRAHEDRON);

        // then
        Assert.assertFalse(actual);
    }
}
