package com.epam.tetraider.sorting.comparators.coordinates;

import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.sorting.comparators.point.PointXComparator;
import com.epam.tetraider.sorting.comparators.tetrahedron.coordinates.BaseTopPointCoordinateComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseTopPointCoordinateComparatorTests {
    private static final Point TWO_POINT = new Point(2, 0, 0);
    private static final Point ONE_POINT = new Point(1, 0, 0);

    private static final NumberedTetrahedron TWO_TETRAHEDRON = new NumberedTetrahedron(
            0,
            new Point(0, 0, 0),
            TWO_POINT,
            new Point(0, 0, 0)
    );

    private static final NumberedTetrahedron ONE_TETRAHEDRON = new NumberedTetrahedron(
            0,
            new Point(0, 0, 0),
            ONE_POINT,
            new Point(0, 0, 0)
    );

    private static final int GREATER = 1;
    private static final int LESS = -1;
    private static final int SIMILAR = 0;

    @Test
    public void testCompareShouldReturnOneWhenFirstGreaterThenSecond() {
        // given
        Comparator<Point> pointComparator = mock(PointXComparator.class);
        when(pointComparator.compare(TWO_POINT, ONE_POINT)).thenReturn(GREATER);

        Comparator<NumberedTetrahedron> tetrahedronComparator = new BaseTopPointCoordinateComparator(pointComparator);

        // when
        int actual = tetrahedronComparator.compare(TWO_TETRAHEDRON, ONE_TETRAHEDRON);

        // then
        Assert.assertEquals(GREATER, actual);
    }

    @Test
    public void testCompareShouldReturnNegativeOneWhenFirstLessThenSecond() {
        // given
        Comparator<Point> pointComparator = mock(PointXComparator.class);
        when(pointComparator.compare(ONE_POINT, TWO_POINT)).thenReturn(LESS);

        Comparator<NumberedTetrahedron> tetrahedronComparator = new BaseTopPointCoordinateComparator(pointComparator);

        // when
        int actual = tetrahedronComparator.compare(ONE_TETRAHEDRON, TWO_TETRAHEDRON);

        // then
        Assert.assertEquals(LESS, actual);
    }

    @Test
    public void testCompareShouldReturnZeroWhenFirstAndSecondSimilar() {
        // given
        Comparator<Point> pointComparator = mock(PointXComparator.class);
        when(pointComparator.compare(ONE_POINT, ONE_POINT)).thenReturn(SIMILAR);

        Comparator<NumberedTetrahedron> tetrahedronComparator = new BaseTopPointCoordinateComparator(pointComparator);

        // when
        int actual = tetrahedronComparator.compare(ONE_TETRAHEDRON, ONE_TETRAHEDRON);

        // then
        Assert.assertEquals(SIMILAR, actual);
    }
}
