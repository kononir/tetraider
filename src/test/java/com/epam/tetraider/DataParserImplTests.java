package com.epam.tetraider;

import com.epam.tetraider.logic.DataParserImpl;
import com.epam.tetraider.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class DataParserImplTests {
    @Test
    public void testParseShouldReturnPointWithThreeFivesCoordinates() {
        // given
        final DataParserImpl dataParser = new DataParserImpl();
        final double expectedXCord = 5;
        final double expectedYCord = 5;
        final double expectedZCord = 5;
        final double delta = 0.01;

        // when
        Point point = dataParser.parse("5.0 5.0 5.0");

        // then
        Assert.assertEquals(expectedXCord, point.getXCord(), delta);
        Assert.assertEquals(expectedYCord, point.getYCord(), delta);
        Assert.assertEquals(expectedZCord, point.getZCord(), delta);
    }
}
