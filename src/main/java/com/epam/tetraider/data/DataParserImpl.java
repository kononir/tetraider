package com.epam.tetraider.data;

import com.epam.tetraider.data.interfaces.DataParser;
import com.epam.tetraider.model.point.Point;

import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    @Override
    public List<Point> parse(String cordsLine) {
        cordsLine = cordsLine.trim();

        String[] cords = cordsLine.split(" ");

        List<Point> result = new ArrayList<>();

        for (int xCordIndex = 0; xCordIndex < 9; xCordIndex += 3) {
            int yCordIndex = xCordIndex + 1;
            int zCordIndex = xCordIndex + 2;

            double xCord = Double.parseDouble(cords[xCordIndex]);
            double yCord = Double.parseDouble(cords[yCordIndex]);
            double zCord = Double.parseDouble(cords[zCordIndex]);

            result.add(new Point(xCord, yCord, zCord));
        }

        return result;
    }
}
