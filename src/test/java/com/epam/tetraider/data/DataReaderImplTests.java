package com.epam.tetraider.data;

import com.epam.tetraider.exceptions.FileIsEmptyException;
import com.epam.tetraider.exceptions.IllegalFileNameException;
import com.epam.tetraider.exceptions.ReadingProblemsException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class DataReaderImplTests {
    private static final String VALID_PATH_WITH_ONE = "src/test/resources/one.txt";
    private static final String INVALID_PATH = "invalid path!";
    private static final String VALID_PATH_EMPTY_FILE = "src/test/resources/empty.txt";

    private static final List<String> EXPECTED = Collections.singletonList("1.0");

    @Test
    public void testReadFileShouldReturnOneWhenReadFileWithOne() throws IllegalFileNameException,
            FileIsEmptyException, ReadingProblemsException {
        // given
        DataReaderImpl dataReader = new DataReaderImpl();

        // when
        List<String> actual = dataReader.readFile(VALID_PATH_WITH_ONE);

        // then
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test (expected = IllegalFileNameException.class)
    public void testReadFileShouldThrowIllegalFileNameExceptionWhenNotFoundFile() throws IllegalFileNameException,
            FileIsEmptyException, ReadingProblemsException {
        // given
        DataReaderImpl dataReader = new DataReaderImpl();

        // when
        dataReader.readFile(INVALID_PATH);

        // then
        Assert.fail();
    }

    @Test (expected = FileIsEmptyException.class)
    public void testReadFileShouldThrowFileIsEmptyExceptionWhenReadEmptyFile() throws IllegalFileNameException,
            FileIsEmptyException, ReadingProblemsException {
        // given
        DataReaderImpl dataReader = new DataReaderImpl();

        // when
        dataReader.readFile(VALID_PATH_EMPTY_FILE);

        // then
        Assert.fail();
    }
}
