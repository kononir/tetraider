package com.epam.tetraider;

import com.epam.tetraider.data.DataParserImpl;
import com.epam.tetraider.data.DataReaderImpl;
import com.epam.tetraider.data.DataValidatorImpl;
import com.epam.tetraider.data.PointsValidatorImpl;
import com.epam.tetraider.data.interfaces.DataParser;
import com.epam.tetraider.data.interfaces.DataReader;
import com.epam.tetraider.data.interfaces.DataValidator;
import com.epam.tetraider.exceptions.FileIsEmptyException;
import com.epam.tetraider.exceptions.IllegalFileNameException;
import com.epam.tetraider.exceptions.ReadingProblemsException;
import com.epam.tetraider.generator.IncrementalGenerator;
import com.epam.tetraider.generator.interfaces.Generator;
import com.epam.tetraider.logic.interfaces.PointsValidator;
import com.epam.tetraider.model.NumberedTetrahedron;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.repository.TetrahedronRepository;
import com.epam.tetraider.repository.interfaces.Repository;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class DirectorTests {
    private static final String VALID_PATH_WITH_TETRAHEDRON = "src/test/resources/valid.txt";
    private static final String VALID_PATH_WITH_INVALID_DATA = "src/test/resources/invalid.txt";
    private static final String INVALID_PATH = "invalid path!";
    private static final String VALID_PATH_EMPTY_FILE = "src/test/resources/empty.txt";

    private static final String VALID_LINE = "5 5 5 5 5 2 3 5 2";
    private static final String INVALID_LINE = "Letter";

    private static final List<String> VALID_LINES = Collections.singletonList(VALID_LINE);
    private static final List<String> INVALID_LINES = Collections.singletonList(INVALID_LINE);

    private static final Point TOP_POINT = new Point(5, 5, 5);
    private static final Point BASE_CENTER_POINT = new Point(5, 5, 2);
    private static final Point BASE_TOP_POINT = new Point(3, 5, 2);

    private static final List<Point> VALID_POINTS = Arrays.asList(
            TOP_POINT,
            BASE_CENTER_POINT,
            BASE_TOP_POINT
    );

    private static final Integer ZERO_ID = 0;

    private static final NumberedTetrahedron TETRAHEDRON = new NumberedTetrahedron(
            ZERO_ID,
            TOP_POINT,
            BASE_CENTER_POINT,
            BASE_TOP_POINT
    );

    private static final int ONE_INVOCATION = 1;

    @Test
    public void testManageLoadingTetrahedronsReturnRepositoryWithOneTetrahedron() throws IllegalFileNameException,
            FileIsEmptyException, ReadingProblemsException {
        // given
        DataReader dataReader = mock(DataReaderImpl.class);

        when(dataReader.readFile(VALID_PATH_WITH_TETRAHEDRON)).thenReturn(VALID_LINES);

        DataValidator dataValidator = mock(DataValidatorImpl.class);
        when(dataValidator.isValidLine(VALID_LINE)).thenReturn(true);

        DataParser dataParser = mock(DataParserImpl.class);

        when(dataParser.parse(VALID_LINE)).thenReturn(VALID_POINTS);

        PointsValidator pointsValidator = mock(PointsValidatorImpl.class);
        when(pointsValidator.isValidPoints(TOP_POINT, BASE_CENTER_POINT, BASE_TOP_POINT)).thenReturn(true);

        Repository<NumberedTetrahedron> repository = spy(new TetrahedronRepository());

        Generator<Integer> generator = mock(IncrementalGenerator.class);
        when(generator.generateNext()).thenReturn(ZERO_ID);

        Director director = new Director(dataReader, dataValidator, dataParser, pointsValidator, repository, generator);

        // when
        director.manageLoadingTetrahedrons(VALID_PATH_WITH_TETRAHEDRON);

        // then
        verify(dataReader, times(ONE_INVOCATION)).readFile(anyString());
        verify(dataValidator, times(ONE_INVOCATION)).isValidLine(VALID_LINE);
        verify(dataParser, times(ONE_INVOCATION)).parse(anyString());
        verify(pointsValidator, times(ONE_INVOCATION)).isValidPoints(TOP_POINT, BASE_CENTER_POINT, BASE_TOP_POINT);

        verify(repository, times(ONE_INVOCATION)).add(TETRAHEDRON);
        verify(generator, times(ONE_INVOCATION)).generateNext();
    }

    @Test
    public void testManageLoadingTetrahedronsReturnEmptyRepositoryWhenDataIsInvalid() throws IllegalFileNameException,
            FileIsEmptyException, ReadingProblemsException {
        // given
        DataReader dataReader = mock(DataReaderImpl.class);

        when(dataReader.readFile(VALID_PATH_WITH_INVALID_DATA)).thenReturn(INVALID_LINES);

        DataValidator dataValidator = mock(DataValidatorImpl.class);
        when(dataValidator.isValidLine(INVALID_LINE)).thenReturn(false);

        DataParser dataParser = mock(DataParserImpl.class);
        PointsValidator pointsValidator = mock(PointsValidatorImpl.class);
        Generator<Integer> generator = mock(IncrementalGenerator.class);

        Repository<NumberedTetrahedron> repository = spy(new TetrahedronRepository());

        Director director = new Director(dataReader, dataValidator, dataParser, pointsValidator, repository, generator);

        // when
        director.manageLoadingTetrahedrons(VALID_PATH_WITH_INVALID_DATA);

        // then
        verify(dataReader, times(ONE_INVOCATION)).readFile(anyString());
        verify(dataValidator, times(ONE_INVOCATION)).isValidLine(INVALID_LINE);

        verify(dataParser, never()).parse(anyString());
        verify(pointsValidator, never()).isValidPoints(anyObject(), anyObject(), anyObject());

        verify(repository, never()).add(anyObject());
        verify(generator, never()).generateNext();
    }

    @Test
    public void testManageLoadingTetrahedronsReturnEmptyRepositoryWhenIllegalFileName() throws IllegalFileNameException,
            FileIsEmptyException, ReadingProblemsException {
        // given
        DataReader dataReader = mock(DataReaderImpl.class);

        when(dataReader.readFile(INVALID_PATH)).thenThrow(new IllegalFileNameException());

        DataValidator dataValidator = mock(DataValidatorImpl.class);
        DataParser dataParser = mock(DataParserImpl.class);
        PointsValidator pointsValidator = mock(PointsValidatorImpl.class);
        Generator<Integer> generator = mock(IncrementalGenerator.class);

        Repository<NumberedTetrahedron> repository = spy(new TetrahedronRepository());

        Director director = new Director(dataReader, dataValidator, dataParser, pointsValidator, repository, generator);

        // when
        director.manageLoadingTetrahedrons(INVALID_PATH);

        // then
        verify(dataReader, times(ONE_INVOCATION)).readFile(anyString());

        verify(dataValidator, never()).isValidLine(anyString());
        verify(dataParser, never()).parse(anyString());
        verify(pointsValidator, never()).isValidPoints(anyObject(), anyObject(), anyObject());

        verify(repository, never()).add(anyObject());
        verify(generator, never()).generateNext();
    }

    @Test
    public void testManageLoadingTetrahedronsReturnEmptyRepositoryWhenFileIsEmpty() throws IllegalFileNameException,
            FileIsEmptyException, ReadingProblemsException {
        // given
        DataReader dataReader = mock(DataReaderImpl.class);

        when(dataReader.readFile(VALID_PATH_EMPTY_FILE)).thenThrow(new FileIsEmptyException());

        DataValidator dataValidator = mock(DataValidatorImpl.class);
        DataParser dataParser = mock(DataParserImpl.class);
        PointsValidator pointsValidator = mock(PointsValidatorImpl.class);
        Generator<Integer> generator = mock(IncrementalGenerator.class);

        Repository<NumberedTetrahedron> repository = spy(new TetrahedronRepository());

        Director director = new Director(dataReader, dataValidator, dataParser, pointsValidator, repository, generator);

        // when
        director.manageLoadingTetrahedrons(VALID_PATH_EMPTY_FILE);

        // then
        // вставить проверку на добавление в репозиторий тетраэдров

        verify(dataReader, times(ONE_INVOCATION)).readFile(anyString());

        verify(dataValidator, never()).isValidLine(anyString());
        verify(dataParser, never()).parse(anyString());
        verify(pointsValidator, never()).isValidPoints(anyObject(), anyObject(), anyObject());

        verify(repository, never()).add(anyObject());
        verify(generator, never()).generateNext();
    }
}
