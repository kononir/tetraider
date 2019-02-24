package com.epam.tetraider.sorting.comparators.tetrahedron.id;

import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.model.point.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class IDComparatorTests {
    private static final NumberedTetrahedron TWO_TETRAHEDRON = new NumberedTetrahedron(
            2,
            new Point(0, 0, 0),
            new Point(0, 0, 0),
            new Point(0, 0, 0)
    );

    private static final NumberedTetrahedron ONE_TETRAHEDRON = new NumberedTetrahedron(
            1,
            new Point(0, 0, 0),
            new Point(0, 0, 0),
            new Point(0, 0, 0)
    );

    private static final int GREATER = 1;
    private static final int LESS = -1;
    private static final int SIMILAR = 0;

    @Test
    public void testCompareShouldReturnOneWhenFirstGreaterThenSecond() {
        Comparator<NumberedTetrahedron> comparator = new IDComparator();

        int actual = comparator.compare(TWO_TETRAHEDRON, ONE_TETRAHEDRON);

        Assert.assertEquals(GREATER, actual);
    }

    @Test
    public void testCompareShouldReturnNegativeOneWhenFirstLessThenSecond() {
        Comparator<NumberedTetrahedron> comparator = new IDComparator();

        int actual = comparator.compare(ONE_TETRAHEDRON, TWO_TETRAHEDRON);

        Assert.assertEquals(LESS, actual);
    }

    @Test
    public void testCompareShouldReturnZeroWhenFirstAndSecondSimilar() {
        Comparator<NumberedTetrahedron> comparator = new IDComparator();

        int actual = comparator.compare(ONE_TETRAHEDRON, ONE_TETRAHEDRON);

        Assert.assertEquals(SIMILAR, actual);
    }
}
