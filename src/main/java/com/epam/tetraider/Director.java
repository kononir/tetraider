package com.epam.tetraider;

import com.epam.tetraider.exceptions.FileIsEmptyException;
import com.epam.tetraider.exceptions.IllegalFileNameException;
import com.epam.tetraider.exceptions.InvalidFileDataException;
import com.epam.tetraider.data.interfaces.DataParser;
import com.epam.tetraider.data.interfaces.DataReader;
import com.epam.tetraider.data.interfaces.DataValidator;
import com.epam.tetraider.exceptions.ReadingProblemsException;
import com.epam.tetraider.logic.interfaces.PointsValidator;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.model.Tetrahedron;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private DataReader reader;
    private DataParser parser;
    private DataValidator dataValidator;
    private PointsValidator pointsValidator;

    private static final Logger LOGGER = Logger.getLogger(Director.class);

    public Director(DataReader reader, DataValidator dataValidator, DataParser parser, PointsValidator pointsValidator) {
        this.reader = reader;
        this.parser = parser;
        this.dataValidator = dataValidator;
        this.pointsValidator = pointsValidator;
    }

    public List<Tetrahedron> manageLoadingTetrahedrons(String filePath) {
        List<Tetrahedron> result = new ArrayList<>();

        try {
            List<String> lines = reader.readFile(filePath);

            int validNumber = 0;

            for (String line: lines)  {
                if (dataValidator.isValidLine(line)) {
                    validNumber++;

                    List<Point> points = parser.parse(line);

                    int topPointIndex = 0;
                    Point topPoint = points.get(topPointIndex);

                    int baseCenterPointIndex = 1;
                    Point baseCenterPoint = points.get(baseCenterPointIndex);

                    int baseTopPointIndex = 2;
                    Point baseTopPoint = points.get(baseTopPointIndex);

                    if (pointsValidator.isValidPoints(topPoint, baseCenterPoint, baseTopPoint)) {
                        result.add(new Tetrahedron(topPoint, baseCenterPoint, baseTopPoint));
                    }
                }
            }

            if (validNumber == 0) {
                throw new InvalidFileDataException();
            }
        } catch (ReadingProblemsException e) {
            LOGGER.error("File reading error!", e);

            e.printStackTrace();
        } catch (IllegalFileNameException e) {
            LOGGER.warn("File with such name doesn't exist!", e);

            e.printStackTrace();
        } catch (InvalidFileDataException e) {
            LOGGER.warn("All data of this file is invalid!", e);

            e.printStackTrace();
        } catch (FileIsEmptyException e) {
            LOGGER.warn("This file is empty!", e);

            e.printStackTrace();
        }

        return result;
    }
}
