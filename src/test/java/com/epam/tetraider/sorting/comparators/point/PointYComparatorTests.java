package com.epam.tetraider.sorting.comparators.point;

import com.epam.tetraider.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class PointYComparatorTests {
    private static final Point TWO_POINT = new Point(0, 2, 0);
    private static final Point ONE_POINT = new Point(0, 1, 0);

    private static final int GREATER = 1;
    private static final int LESS = -1;
    private static final int SIMILAR = 0;

    @Test
    public void testCompareShouldReturnOneWhenFirstGreaterThenSecond() {
        // given
        Comparator<Point> pointComparator = new PointYComparator();

        // when
        int actual = pointComparator.compare(TWO_POINT, ONE_POINT);

        // then
        Assert.assertEquals(GREATER, actual);
    }

    @Test
    public void testCompareShouldReturnNegativeOneWhenFirstLessThenSecond() {
        // given
        Comparator<Point> pointComparator = new PointYComparator();

        // when
        int actual = pointComparator.compare(ONE_POINT, TWO_POINT);

        // then
        Assert.assertEquals(LESS, actual);
    }

    @Test
    public void testCompareShouldReturnZeroWhenFirstAndSecondSimilar() {
        // given
        Comparator<Point> pointComparator = new PointYComparator();

        // when
        int actual = pointComparator.compare(ONE_POINT, ONE_POINT);

        // then
        Assert.assertEquals(SIMILAR, actual);
    }
}
