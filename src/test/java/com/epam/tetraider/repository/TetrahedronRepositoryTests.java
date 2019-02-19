package com.epam.tetraider.repository;

import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import com.epam.tetraider.repository.specifications.tetrahedron.OctantSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class TetrahedronRepositoryTests {
    private final static Integer ID = 1;

    private final static NumberedTetrahedron TETRAHEDRON = new NumberedTetrahedron(
            ID,
            new Point(1, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 1, 1)
    );

    private final static int ONE_ELEMENT = 1;

    private final static int FIRST_INDEX = 0;

    private final static double COORDINATE = 1;
    private final static double DELTA = 0.01;

    private final static int ONE_INVOCATION = 1;

    @Test
    public void testQueryShouldReturnOneTetrahedronWhenSpecifiedGiveTrue() {
        // given
        Specification<NumberedTetrahedron> specification = mock(OctantSpecification.class);
        when(specification.specified(TETRAHEDRON)).thenReturn(true);

        TetrahedronRepository repository = new TetrahedronRepository();

        repository.add(TETRAHEDRON);

        // when
        List<NumberedTetrahedron> tetrahedronList = repository.query(specification);

        // then
        Assert.assertEquals(ONE_ELEMENT, tetrahedronList.size());

        NumberedTetrahedron actual = tetrahedronList.get(FIRST_INDEX);

        Assert.assertEquals(ID, actual.getId());

        Point topPoint = actual.getTopPoint();
        Assert.assertEquals(COORDINATE, topPoint.getXCord(), DELTA);
        Assert.assertEquals(COORDINATE, topPoint.getYCord(), DELTA);
        Assert.assertEquals(COORDINATE, topPoint.getZCord(), DELTA);

        Point baseTopPoint = actual.getBaseTopPoint();
        Assert.assertEquals(COORDINATE, baseTopPoint.getXCord(), DELTA);
        Assert.assertEquals(COORDINATE, baseTopPoint.getYCord(), DELTA);
        Assert.assertEquals(COORDINATE, baseTopPoint.getZCord(), DELTA);

        Point baseCenterPoint = actual.getBaseCenterPoint();
        Assert.assertEquals(COORDINATE, baseCenterPoint.getXCord(), DELTA);
        Assert.assertEquals(COORDINATE, baseCenterPoint.getYCord(), DELTA);
        Assert.assertEquals(COORDINATE, baseCenterPoint.getZCord(), DELTA);

        verify(specification, times(ONE_INVOCATION)).specified(TETRAHEDRON);
    }

    @Test
    public void testQueryShouldReturnNoneTetrahedronsWhenSpecifiedGiveFalse() {
        // given
        Specification<NumberedTetrahedron> specification = mock(OctantSpecification.class);
        when(specification.specified(TETRAHEDRON)).thenReturn(false);

        TetrahedronRepository repository = new TetrahedronRepository();

        repository.add(TETRAHEDRON);

        // when
        List<NumberedTetrahedron> tetrahedronList = repository.query(specification);

        // then
        Assert.assertTrue(tetrahedronList.isEmpty());

        verify(specification, times(ONE_INVOCATION)).specified(TETRAHEDRON);
    }
}
