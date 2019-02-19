package com.epam.tetraider.data;

import com.epam.tetraider.data.DataParserImpl;
import com.epam.tetraider.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataParserImplTests {
    private final static List<Point> EXPECTED = Arrays.asList(
            new Point(5, 5, 5),
            new Point(5, 5, 5),
            new Point(5, 5, 5)
    );

    private final static String CORDS_LINE = "5.0 5.0 5.0 5.0 5.0 5.0 5.0 5.0 5.0";

    @Test
    public void testParseShouldReturnPointWithThreeFivesCoordinates() {
        // given
        DataParserImpl dataParser = new DataParserImpl();

        // when
        List<Point> ACTUAL = dataParser.parse(CORDS_LINE);

        // then
        Assert.assertEquals(EXPECTED, ACTUAL);
    }
}
