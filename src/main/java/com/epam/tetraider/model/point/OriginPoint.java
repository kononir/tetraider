package com.epam.tetraider.model.point;

import com.epam.tetraider.model.point.Point;

public class OriginPoint {
    private static Point instance;

    public static Point getInstance() {
        if (instance == null) {
            double zeroCord = 0;

            instance = new Point(zeroCord, zeroCord, zeroCord);
        }

        return instance;
    }
}
