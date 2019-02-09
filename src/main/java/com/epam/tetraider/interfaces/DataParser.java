package com.epam.tetraider.interfaces;

import com.epam.tetraider.model.Point;

public interface DataParser {
    Point parse(String pointCordsLine);
}
