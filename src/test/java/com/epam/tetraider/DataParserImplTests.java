package com.epam.tetraider;

import com.epam.tetraider.data.DataParserImpl;
import com.epam.tetraider.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataParserImplTests {
    @Test
    public void testParseShouldReturnPointWithThreeFivesCoordinates() {
        // given
        final DataParserImpl dataParser = new DataParserImpl();
        final double cord = 5;

        final List<Point> expected = Arrays.asList(new Point(cord, cord, cord),
                new Point(cord, cord, cord),
                new Point(cord, cord, cord));

        // when
        List<Point> points = dataParser.parse("5.0 5.0 5.0 5.0 5.0 5.0 5.0 5.0 5.0");

        // then
        Assert.assertEquals(expected, points);
    }
}
