package com.epam.tetraider.sorting.comparators.point;

import com.epam.tetraider.model.point.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class PointXComparatorTests {
    private static final Point TWO_POINT = new Point(2, 0, 0);
    private static final Point ONE_POINT = new Point(1, 0, 0);

    private static final int GREATER = 1;
    private static final int LESS = -1;
    private static final int SIMILAR = 0;

    @Test
    public void testCompareShouldReturnOneWhenFirstGreaterThenSecond() {
        // given
        Comparator<Point> pointComparator = new PointXComparator();

        // when
        int actual = pointComparator.compare(TWO_POINT, ONE_POINT);

        // then
        Assert.assertEquals(GREATER, actual);
    }

    @Test
    public void testCompareShouldReturnNegativeOneWhenFirstLessThenSecond() {
        // given
        Comparator<Point> pointComparator = new PointXComparator();

        // when
        int actual = pointComparator.compare(ONE_POINT, TWO_POINT);

        // then
        Assert.assertEquals(LESS, actual);
    }

    @Test
    public void testCompareShouldReturnZeroWhenFirstAndSecondSimilar() {
        // given
        Comparator<Point> pointComparator = new PointXComparator();

        // when
        int actual = pointComparator.compare(ONE_POINT, ONE_POINT);

        // then
        Assert.assertEquals(SIMILAR, actual);
    }
}
