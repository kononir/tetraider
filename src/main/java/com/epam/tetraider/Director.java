package com.epam.tetraider;

import com.epam.tetraider.exceptions.FileIsEmptyException;
import com.epam.tetraider.exceptions.IllegalFileNameException;
import com.epam.tetraider.exceptions.InvalidFileDataException;
import com.epam.tetraider.data.interfaces.DataParser;
import com.epam.tetraider.data.interfaces.DataReader;
import com.epam.tetraider.data.interfaces.DataValidator;
import com.epam.tetraider.logic.interfaces.PointsValidator;
import com.epam.tetraider.model.Point;
import com.epam.tetraider.model.Tetrahedron;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Director {
    private DataReader reader;
    private DataParser parser;
    private DataValidator dataValidator;
    private PointsValidator pointsValidator;

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
        } catch (IOException | IllegalFileNameException | InvalidFileDataException | FileIsEmptyException e) {
            e.printStackTrace();
        }

        return result;
    }
}
