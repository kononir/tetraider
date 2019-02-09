package com.epam.tetraider.logic;

import com.epam.tetraider.interfaces.DataParser;
import com.epam.tetraider.model.Point;

public class DataParserImpl implements DataParser {
    @Override
    public Point parse(String pointCordsLine) {
        double xCord = 5;
        double yCord = 5;
        double zCord = 5;

        return new Point(xCord, yCord, zCord);
    }
}
