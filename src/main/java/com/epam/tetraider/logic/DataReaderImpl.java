package com.epam.tetraider.logic;

import com.epam.tetraider.interfaces.DataReader;

import java.io.*;

public class DataReaderImpl implements DataReader {
    private BufferedReader bufferedReader;

    public DataReaderImpl(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
    }

    @Override
    public String readLine() throws IOException {
        String line;

        if ((line = bufferedReader.readLine()) == null) {
            bufferedReader.close();
        }

        return line;
    }

    public void close() throws IOException {
        bufferedReader.close();
    }
}
