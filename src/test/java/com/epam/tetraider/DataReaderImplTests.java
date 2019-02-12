package com.epam.tetraider;

import com.epam.tetraider.data.DataReaderImpl;
import com.epam.tetraider.exceptions.FileIsEmptyException;
import com.epam.tetraider.exceptions.IllegalFileNameException;
import com.epam.tetraider.exceptions.ReadingProblemsException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DataReaderImplTests {
    @Test
    public void testReadFileShouldReturnOneWhenReadFileWithOne() throws IllegalFileNameException,
            FileIsEmptyException, ReadingProblemsException {
        // given
        DataReaderImpl dataReader = new DataReaderImpl();
        String path = "src/test/resources/one.txt";
        List<String> expected = Collections.singletonList("1");

        // when
        List<String> actual = dataReader.readFile(path);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = IllegalFileNameException.class)
    public void testReadFileShouldThrowIllegalFileNameException() throws IllegalFileNameException,
            FileIsEmptyException, ReadingProblemsException {
        // given
        DataReaderImpl dataReader = new DataReaderImpl();
        String path = "src/test/resources/illegalName.txt";

        // when
        dataReader.readFile(path);

        // then
        Assert.fail();
    }

    @Test (expected = FileIsEmptyException.class)
    public void testReadFileShouldThrowFileIsEmptyExceptionWhenReadEmptyFile() throws IllegalFileNameException,
            FileIsEmptyException, ReadingProblemsException {
        // given
        DataReaderImpl dataReader = new DataReaderImpl();
        List<String> expected = new LinkedList<>();
        String path = "src/test/resources/empty.txt";

        // when
        List<String> actual = dataReader.readFile(path);

        // then
        Assert.assertEquals(expected, actual);
    }
}
