package com.epam.tetraider;

import com.epam.tetraider.data.DataParserImpl;
import com.epam.tetraider.data.DataReaderImpl;
import com.epam.tetraider.data.DataValidatorImpl;
import com.epam.tetraider.exceptions.FileIsEmptyException;
import com.epam.tetraider.exceptions.IllegalFileNameException;
import com.epam.tetraider.data.interfaces.DataParser;
import com.epam.tetraider.data.interfaces.DataReader;
import com.epam.tetraider.data.interfaces.DataValidator;
import com.epam.tetraider.logic.PointsValidatorImpl;
import com.epam.tetraider.logic.interfaces.PointsValidator;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.model.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class DirectorTests {
    @Test
    public void testManageLoadingTetrahedronsReturnListWithOneTetrahedron() throws IllegalFileNameException,
            FileIsEmptyException, IOException {
        // given
        DataReader dataReader = mock(DataReaderImpl.class);

        String path = "src/test/resources/valid.txt";

        String line = "5 5 5 5 5 2 3 5 2";
        List<String> lines = Collections.singletonList(line);

        when(dataReader.readFile(path)).thenReturn(lines);

        DataValidator dataValidator = mock(DataValidatorImpl.class);
        when(dataValidator.isValidLine(line)).thenReturn(true);

        DataParser dataParser = mock(DataParserImpl.class);

        final double fiveCord = 5;
        final double twoCord = 2;
        final double threeCord = 3;

        Point topPoint = new Point(fiveCord, fiveCord, fiveCord);
        Point baseCenterPoint = new Point(fiveCord, fiveCord, twoCord);
        Point baseTopPoint = new Point(threeCord, fiveCord, twoCord);

        final List<Point> points = Arrays.asList(topPoint, baseCenterPoint, baseTopPoint);

        when(dataParser.parse(line)).thenReturn(points);

        PointsValidator pointsValidator = mock(PointsValidatorImpl.class);
        when(pointsValidator.isValidPoints(topPoint, baseCenterPoint, baseTopPoint)).thenReturn(true);

        Director director = new Director(dataReader, dataValidator, dataParser, pointsValidator);

        Tetrahedron tetrahedron = new Tetrahedron(topPoint, baseCenterPoint, baseTopPoint);
        List<Tetrahedron> expected = Collections.singletonList(tetrahedron);

        // when
        List<Tetrahedron> actual = director.manageLoadingTetrahedrons(path);

        // then
        Assert.assertEquals(expected, actual);

        int numberOfInvocation = 1;

        verify(dataReader, times(numberOfInvocation)).readFile(anyString());
        verify(dataValidator, times(numberOfInvocation)).isValidLine(line);
        verify(dataParser, times(numberOfInvocation)).parse(anyString());
        verify(pointsValidator, times(numberOfInvocation)).isValidPoints(topPoint, baseCenterPoint, baseTopPoint);
    }

    @Test
    public void testManageLoadingTetrahedronsReturnEmptyList() throws IllegalFileNameException,
            FileIsEmptyException, IOException {
        // given
        DataReader dataReader = mock(DataReaderImpl.class);

        String path = "src/test/resources/invalid.txt";

        String line = "Letter";
        List<String> lines = Collections.singletonList(line);

        when(dataReader.readFile(path)).thenReturn(lines);

        DataValidator dataValidator = mock(DataValidatorImpl.class);
        when(dataValidator.isValidLine(line)).thenReturn(false);

        DataParser dataParser = mock(DataParserImpl.class);

        PointsValidator pointsValidator = mock(PointsValidatorImpl.class);

        Director director = new Director(dataReader, dataValidator, dataParser, pointsValidator);

        List<Tetrahedron> expected = Collections.emptyList();

        // when
        List<Tetrahedron> actual = director.manageLoadingTetrahedrons(path);

        // then
        Assert.assertEquals(expected, actual);

        int numberOfInvocation = 1;

        verify(dataReader, times(numberOfInvocation)).readFile(anyString());
        verify(dataValidator, times(numberOfInvocation)).isValidLine(line);

        verify(dataParser, never()).parse(anyString());
        verify(pointsValidator, never()).isValidPoints((Point) anyObject(), (Point) anyObject(), (Point) anyObject());
    }
}
