package com.epam.tetraider;

import com.epam.tetraider.data.interfaces.DataParser;
import com.epam.tetraider.data.interfaces.DataReader;
import com.epam.tetraider.data.interfaces.DataValidator;
import com.epam.tetraider.exceptions.FileIsEmptyException;
import com.epam.tetraider.exceptions.IllegalFileNameException;
import com.epam.tetraider.exceptions.InvalidFileDataException;
import com.epam.tetraider.exceptions.ReadingProblemsException;
import com.epam.tetraider.generator.interfaces.Generator;
import com.epam.tetraider.logic.interfaces.PointsValidator;
import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;
import com.epam.tetraider.model.point.Point;
import com.epam.tetraider.repository.interfaces.Repository;
import org.apache.log4j.Logger;

import java.util.List;

public class Director {
    private DataReader reader;
    private DataParser parser;
    private DataValidator dataValidator;
    private PointsValidator pointsValidator;

    private Repository<NumberedTetrahedron> repository;
    private Generator<Integer> generator;

    private static final Logger LOGGER = Logger.getLogger(Director.class);

    public Director(DataReader reader, DataValidator dataValidator, DataParser parser,
                    PointsValidator pointsValidator, Repository<NumberedTetrahedron> repository,
                    Generator<Integer> generator) {
        this.reader = reader;
        this.parser = parser;
        this.dataValidator = dataValidator;
        this.pointsValidator = pointsValidator;

        this.repository = repository;
        this.generator = generator;
    }

    public void manageLoadingTetrahedrons(String filePath) {
        int numOfValidLines = 0;

        try {
            List<String> lines = reader.readFile(filePath);

            for (String line: lines)  {
                if (dataValidator.isValidLine(line)) {
                    numOfValidLines++;

                    List<Point> points = parser.parse(line);

                    int topPointIndex = 0;
                    Point topPoint = points.get(topPointIndex);

                    int baseCenterPointIndex = 1;
                    Point baseCenterPoint = points.get(baseCenterPointIndex);

                    int baseTopPointIndex = 2;
                    Point baseTopPoint = points.get(baseTopPointIndex);

                    if (pointsValidator.isValidPoints(topPoint, baseCenterPoint, baseTopPoint)) {
                        int id = generator.generateNext();

                        repository.add(new NumberedTetrahedron(id, topPoint, baseCenterPoint, baseTopPoint));
                    }
                }
            }

            if (numOfValidLines == 0) {
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
    }
}
