package com.epam.tetraider.observer;

import com.epam.tetraider.logic.TetrahedronCalculatorImpl;
import com.epam.tetraider.logic.interfaces.TetrahedronCalculator;
import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.model.tetrahedron.TetrahedronParameters;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TetrahedronObserverTests {

    private final static double AREA = 10;
    private final static double VOLUME = 30;
    private final static Integer ID = 1;
    private final static double DELTA = 0.01;
    private final static int ONE_INVOCATION = 1;

    private final static ObservableTetrahedron TETRAHEDRON = new ObservableTetrahedron(
            ID,
            new Point(2, 2, 2),
            new Point(2, 2, 2),
            new Point(2, 2, 2)
    );

    @Test
    public void testUpdateShouldReturnNewParametersOfTetrahedronWhenTheyWereChanged() {
        // given
        TetrahedronCalculator calculator = mock(TetrahedronCalculatorImpl.class);

        when(calculator.calculateSurfaceArea(TETRAHEDRON)).thenReturn(AREA);
        when(calculator.calculateVolume(TETRAHEDRON)).thenReturn(VOLUME);

        TetrahedronObserver observer = TetrahedronObserver.getInstance(calculator);

        // when
        observer.update(TETRAHEDRON);

        // then
        TetrahedronParameters parameters = observer.getTetrahedronParameters(ID);

        Assert.assertEquals(AREA, parameters.getArea(), DELTA);
        Assert.assertEquals(VOLUME, parameters.getVolume(), DELTA);

        verify(calculator, times(ONE_INVOCATION)).calculateSurfaceArea(TETRAHEDRON);
        verify(calculator, times(ONE_INVOCATION)).calculateVolume(TETRAHEDRON);
    }
}
