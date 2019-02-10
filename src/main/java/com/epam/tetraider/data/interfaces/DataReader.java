package com.epam.tetraider.data.interfaces;

import com.epam.tetraider.exceptions.FileIsEmptyException;
import com.epam.tetraider.exceptions.IllegalFileNameException;

import java.io.IOException;
import java.util.List;

public interface DataReader {
    List<String> readFile(String filePath) throws IOException, IllegalFileNameException, FileIsEmptyException;
}
