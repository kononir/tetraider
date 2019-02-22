package com.epam.tetraider.repository.specifications;

import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import com.epam.tetraider.repository.specifications.tetrahedron.IDSpecification;
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

    @Test
    public void testSpecifiedShouldReturnTrueWhenTetrahedronCorrespondToSpecification() {
        // given
        Specification<NumberedTetrahedron> specification = new IDSpecification(DESIRED_ID);

        // when
        boolean actual = specification.specified(TRUE_TETRAHEDRON);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenTetrahedronNotCorrespondToSpecification() {
        // given
        Specification<NumberedTetrahedron> specification = new IDSpecification(DESIRED_ID);

        // when
        boolean actual = specification.specified(FALSE_TETRAHEDRON);

        // then
        Assert.assertFalse(actual);
    }
}
