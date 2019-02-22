package com.epam.tetraider.sorting;

import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.sorting.comparators.tetrahedron.id.IDComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SorterTests {
    private static final NumberedTetrahedron ONE_TETRAHEDRON = new NumberedTetrahedron(
            1,
            new Point(0, 0, 0),
            new Point(0, 0, 0),
            new Point(0, 0, 0)
    );

    private static final NumberedTetrahedron ONE_THOUSAND_TETRAHEDRON = new NumberedTetrahedron(
            1000,
            new Point(0, 0, 0),
            new Point(0, 0, 0),
            new Point(0, 0, 0)
    );

    private static final List<NumberedTetrahedron> SHUFFLED = Arrays.asList(
            ONE_THOUSAND_TETRAHEDRON,
            ONE_TETRAHEDRON
    );

    private static final List<NumberedTetrahedron> SORTED = Arrays.asList(
            ONE_TETRAHEDRON,
            ONE_THOUSAND_TETRAHEDRON
    );

    private static final int GREATER = 1;
    private static final int LESS = -1;

    @Test
    public void testSortShouldReplaceTetrahedronsWhenTheyShuffled() {
        // given
        Comparator<NumberedTetrahedron> comparator = mock(IDComparator.class);
        when(comparator.compare(ONE_TETRAHEDRON, ONE_THOUSAND_TETRAHEDRON)).thenReturn(LESS);
        when(comparator.compare(ONE_THOUSAND_TETRAHEDRON, ONE_TETRAHEDRON)).thenReturn(GREATER);

        Sorter sorter = new Sorter(comparator);

        // when
        sorter.sort(SHUFFLED);

        // then
        Assert.assertEquals(SORTED, SHUFFLED);
    }

    @Test
    public void testSortShouldNotReplaceTetrahedronsWhenTheySorted() {
        // given
        Comparator<NumberedTetrahedron> comparator = mock(IDComparator.class);
        when(comparator.compare(ONE_TETRAHEDRON, ONE_THOUSAND_TETRAHEDRON)).thenReturn(LESS);
        when(comparator.compare(ONE_THOUSAND_TETRAHEDRON, ONE_TETRAHEDRON)).thenReturn(GREATER);

        Sorter sorter = new Sorter(comparator);

        // when
        sorter.sort(SORTED);

        // then
        Assert.assertEquals(SORTED, SORTED);
    }
}
