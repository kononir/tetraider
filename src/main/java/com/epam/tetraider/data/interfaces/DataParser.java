package com.epam.tetraider.data.interfaces;

import com.epam.tetraider.model.Point;

import java.util.List;

public interface DataParser {
    List<Point> parse(String pointCordsLine);
}
