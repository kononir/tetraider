package com.epam.tetraider.repository;

import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.Specification;
import com.epam.tetraider.repository.specifications.tetrahedron.OctantSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

public class TetrahedronRepositoryTests {
    private final static Integer ID = 1;

    private final static NumberedTetrahedron TETRAHEDRON = new NumberedTetrahedron(
            ID,
            new Point(1, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 1, 1)
    );

    private final static int ONE_TETRAHEDRON = 1;

    @Test
    public void testQueryShouldReturnNoneTetrahedronsWhenRepositoryIsEmpty() {
        // given
        Specification<NumberedTetrahedron> specification = mock(OctantSpecification.class);
        when(specification.specified(TETRAHEDRON)).thenReturn(false);

        TetrahedronRepository repository = new TetrahedronRepository();

        // when
        List<NumberedTetrahedron> tetrahedronList = repository.query(specification);

        // then
        Assert.assertTrue(tetrahedronList.isEmpty());
    }

    @Test
    public void testAddShouldAddTetrahedronToRepositoryWhenRepositoryNotHasIt() {
        // given
        TetrahedronRepository repository = new TetrahedronRepository();

        // when
        repository.add(TETRAHEDRON);

        // then
        Map<Integer, NumberedTetrahedron> tetrahedronsMap = repository.getTetrahedrons();
        Collection<NumberedTetrahedron> tetrahedrons = tetrahedronsMap.values();

        boolean collectionContainsTetrahedron = tetrahedrons.contains(TETRAHEDRON);

        Assert.assertTrue(collectionContainsTetrahedron);
    }

    @Test
    public void testAddShouldNotAddTetrahedronToRepositoryWhenRepositoryAlreadyHasIt() {
        // given
        TetrahedronRepository repository = new TetrahedronRepository();
        repository.add(TETRAHEDRON);

        // when
        repository.add(TETRAHEDRON);

        // then
        Map<Integer, NumberedTetrahedron> tetrahedronsMap = repository.getTetrahedrons();
        Collection<NumberedTetrahedron> tetrahedrons = tetrahedronsMap.values();

        boolean collectionContainsTetrahedron = tetrahedrons.contains(TETRAHEDRON);

        int tetrahedronsNumber = tetrahedrons.size();

        Assert.assertTrue(collectionContainsTetrahedron);
        Assert.assertEquals(ONE_TETRAHEDRON, tetrahedronsNumber);
    }
}
