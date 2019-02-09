package com.epam.tetraider;

import com.epam.tetraider.logic.DataReaderImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataReaderImplTests {
    @Test
    public void testReadLineShouldReturnOneWhenReadFileWithOne() throws IOException {
        // given
        String path = "src/test/resources/one.txt";
        DataReaderImpl dataReader = new DataReaderImpl(path);
        String expected = "1";

        // when
        String actual = dataReader.readLine();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = FileNotFoundException.class)
    public void testReadLineShouldThrowIllegalPathException() throws IOException {
        // given
        String path = "src/test/resources/illegalName.txt";
        DataReaderImpl dataReader = new DataReaderImpl(path);

        // when
        dataReader.readLine();

        // then
        Assert.fail();
    }

    @Test
    public void testReadLineShouldReturnNullWhenReachedFileEnd() throws IOException {
        // given
        String path = "src/test/resources/empty.txt";
        DataReaderImpl dataReader = new DataReaderImpl(path);

        // when
        String actual = dataReader.readLine();

        // then
        Assert.assertNull(actual);
    }
}
