package com.epam.tetraider.logic;

import com.epam.tetraider.logic.interfaces.TetrahedronCalculator;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.model.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class TetrahedronCalculatorImplTests {
    private static final Tetrahedron AREA_VOLUME_TETRAHEDRON = new Tetrahedron(
            new Point(0, 0, 6),
            new Point(0, 0, 0),
            new Point(2, 0, 0)
    );

    private static final Tetrahedron NON_ZERO_DISSECT_RATIO_TETRAHEDRON = new Tetrahedron(
            new Point(5, 5, 3),
            new Point(5, 5, -3),
            new Point(9, 5, -3)
    );

    private static final Tetrahedron ABOVE_ZERO_DISSECT_RATIO_TETRAHEDRON = new Tetrahedron(
            new Point(5, 5, 7),
            new Point(5, 5, 1),
            new Point(9, 5, 1)
    );

    private static final Tetrahedron BELOW_ZERO_DISSECT_RATIO_TETRAHEDRON = new Tetrahedron(
            new Point(5, 5, -1),
            new Point(5, 5, -7),
            new Point(9, 5, -7)
    );

    private static final Tetrahedron LIEN_TETRAHEDRON = new Tetrahedron(
            new Point(0, 5, 5),
            new Point(5, 10, 0),
            new Point(5, 5, 0)
    );

    private static final Tetrahedron NOT_LIEN_TETRAHEDRON = new Tetrahedron(
            new Point(5, 5, 5),
            new Point(5, 5, 5),
            new Point(5, 5, 5)
    );

    private static final double EXPECTED_AREA = 20.78;
    private static final double EXPECTED_VOLUME = 5.19;
    private static final double EXPECTED_NON_ZERO_DISSECT_RATIO = 0.14;
    private static final double EXPECTED_ZERO_DISSECT_RATIO = 0;

    private static final double DELTA = 0.01;

    @Test
    public void testCalculateAreaShouldReturnTwentyWhenInscribedRadiusEqualsTwo() {
        // given
        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        double actual = tetrahedronCalculator.calculateSurfaceArea(AREA_VOLUME_TETRAHEDRON);

        // then
        Assert.assertEquals(EXPECTED_AREA, actual, DELTA);
    }

    @Test
    public void testCalculateVolumeShouldReturnFiveWhenInscribedRadiusEqualsTwo() {
        // given
        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        double actual = tetrahedronCalculator.calculateVolume(AREA_VOLUME_TETRAHEDRON);

        // then
        Assert.assertEquals(EXPECTED_VOLUME, actual, DELTA);
    }

    @Test
    public void testCalculateFigureDissectRatioShouldReturnFourteenTenthsWhenHeightLengthIsSixAndCoordinatesPlaneLiesAtCenter() {
        // given
        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        double actual = tetrahedronCalculator.calculateFigureDissectRatio(NON_ZERO_DISSECT_RATIO_TETRAHEDRON);

        // then
        Assert.assertEquals(EXPECTED_NON_ZERO_DISSECT_RATIO, actual, DELTA);
    }

    @Test
    public void testCalculateFigureDissectRatioShouldReturnZeroWhenTetrahedronLiesAboveCoordinatesPlane() {
        // given
        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        double actual = tetrahedronCalculator.calculateFigureDissectRatio(ABOVE_ZERO_DISSECT_RATIO_TETRAHEDRON);

        // then
        Assert.assertEquals(EXPECTED_ZERO_DISSECT_RATIO, actual, DELTA);
    }

    @Test
    public void testCalculateFigureDissectRatioShouldReturnZeroWhenTetrahedronBelowCoordinatesPlane() {
        // given
        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        double actual = tetrahedronCalculator.calculateFigureDissectRatio(BELOW_ZERO_DISSECT_RATIO_TETRAHEDRON);

        // then
        Assert.assertEquals(EXPECTED_ZERO_DISSECT_RATIO, actual, DELTA);
    }

    @Test
    public void testIsBaseLiesAtCoordinatePlaneShouldReturnTrueWhenGivenTetrahedronBasePointsHaveZeroCoordinatesInSimilarPlane() {
        // given
        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        boolean actual = tetrahedronCalculator.isBaseLiesAtCoordinatePlane(LIEN_TETRAHEDRON);

        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsBaseLiesAtCoordinatePlaneShouldReturnFalseWhenGivenTetrahedronBasePointsNotHaveZeroCoordinatesInSimilarPlane() {
        // given
        TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculatorImpl();

        // when
        boolean actual = tetrahedronCalculator.isBaseLiesAtCoordinatePlane(NOT_LIEN_TETRAHEDRON);

        // then
        Assert.assertFalse(actual);
    }
}
