package com.epam.tetraider.data.interfaces;

import com.epam.tetraider.exceptions.FileIsEmptyException;
import com.epam.tetraider.exceptions.IllegalFileNameException;
import com.epam.tetraider.exceptions.ReadingProblemsException;

import java.io.IOException;
import java.util.List;

public interface DataReader {
    List<String> readFile(String filePath) throws IllegalFileNameException, FileIsEmptyException, ReadingProblemsException;
}
