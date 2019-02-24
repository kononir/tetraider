package com.epam.tetraider.repository.specifications.tetrahedron;

import com.epam.tetraider.exceptions.SpecificationInvalidParametersException;
import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import org.junit.Assert;
import org.junit.Test;

public class IDSpecificationTests {
    private final static NumberedTetrahedron TRUE_TETRAHEDRON = new NumberedTetrahedron(
            1,
            new Point(1, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 1, 1)
    );

    private final static NumberedTetrahedron FALSE_TETRAHEDRON = new NumberedTetrahedron(
            10000,
            new Point(1, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 1, 1)
    );

    private final static Integer DESIRED_ID = 1;
    private final static Integer NULL_DESIRED_ID = null;

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification()
            throws SpecificationInvalidParametersException {
        // given
        Specification<NumberedTetrahedron> specification = new IDSpecification(DESIRED_ID);

        // when
        boolean actual = specification.specified(TRUE_TETRAHEDRON);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenTetrahedronNotCorrespondToSpecification()
            throws SpecificationInvalidParametersException {
        // given
        Specification<NumberedTetrahedron> specification = new IDSpecification(DESIRED_ID);

        // when
        boolean actual = specification.specified(FALSE_TETRAHEDRON);

        // then
        Assert.assertFalse(actual);
    }

    @Test (expected = SpecificationInvalidParametersException.class)
    public void testSpecifiedShouldThrowExceptionWhenGivenNull()
            throws SpecificationInvalidParametersException {
        // given

        // when
        new IDSpecification(NULL_DESIRED_ID);

        // then
        Assert.fail();
    }
}
