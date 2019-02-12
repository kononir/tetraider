package com.epam.tetraider.data;

import com.epam.tetraider.exceptions.FileIsEmptyException;
import com.epam.tetraider.exceptions.IllegalFileNameException;
import com.epam.tetraider.data.interfaces.DataReader;
import com.epam.tetraider.exceptions.ReadingProblemsException;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class DataReaderImpl implements DataReader {

    @Override
    public List<String> readFile(String filePath) throws IllegalFileNameException, FileIsEmptyException, ReadingProblemsException {
        List<String> result;

        try (FileReader fileReader = new FileReader(filePath);) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            result = new LinkedList<>();

            String line;

            if ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }

            if (result.isEmpty()) {
                throw new FileIsEmptyException();
            }
        } catch (FileNotFoundException e) {
            throw new IllegalFileNameException(e);
        } catch (IOException e) {
            throw new ReadingProblemsException(e);
        }

        return result;
    }
}
