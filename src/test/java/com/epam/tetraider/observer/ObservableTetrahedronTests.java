package com.epam.tetraider.observer;

import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.observer.interfaces.Observer;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ObservableTetrahedronTests {
    private final static ObservableTetrahedron TETRAHEDRON = new ObservableTetrahedron(
            1,
            new Point(5, 5, 5),
            new Point(5, 5, 5),
            new Point(5, 5, 5)
    );

    private final static Point NEW_POINT = new Point(1, 1, 1);
    private final static int ONE_INVOCATION = 1;

    @Test
    public void testSetTopPointShouldUpdateAllObserversWhenGivenPointWithNewCoordinates() {
        // given
        Observer<NumberedTetrahedron> observer = mock(TetrahedronObserver.class);
        TETRAHEDRON.addObserver(observer);

        // when
        TETRAHEDRON.setTopPoint(NEW_POINT);

        // then
        verify(observer, times(ONE_INVOCATION)).update(TETRAHEDRON);
    }

    @Test
    public void testSetBaseCenterPointShouldUpdateAllObserversWhenGivenPointWithNewCoordinates() {
        // given
        Observer<NumberedTetrahedron> observer = mock(TetrahedronObserver.class);
        TETRAHEDRON.addObserver(observer);

        // when
        TETRAHEDRON.setBaseCenterPoint(NEW_POINT);

        // then
        verify(observer, times(ONE_INVOCATION)).update(TETRAHEDRON);
    }

    @Test
    public void testSetBaseTopPointShouldUpdateAllObserversWhenGivenPointWithNewCoordinates() {
        // given
        Observer<NumberedTetrahedron> observer = mock(TetrahedronObserver.class);
        TETRAHEDRON.addObserver(observer);

        // when
        TETRAHEDRON.setBaseTopPoint(NEW_POINT);

        // then
        verify(observer, times(ONE_INVOCATION)).update(TETRAHEDRON);
    }
}
