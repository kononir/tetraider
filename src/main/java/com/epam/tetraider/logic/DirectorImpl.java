package com.epam.tetraider.logic;

import com.epam.tetraider.interfaces.DataReader;
import com.epam.tetraider.interfaces.Director;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DirectorImpl implements Director {
    @Override
    public void manageLoadingFileData(String filePath) {
        try {
            DataReader reader = new DataReaderImpl(filePath);

            String nextLine;

            while ((nextLine = reader.readLine()) != null) {

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
