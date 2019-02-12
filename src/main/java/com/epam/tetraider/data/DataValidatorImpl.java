package com.epam.tetraider.data;

import com.epam.tetraider.data.interfaces.DataValidator;

public class DataValidatorImpl implements DataValidator {
    @Override
    public boolean isValidLine(String dataLine) {
        final String coordinatesRegExp = "^(-?\\d\\.\\d\\s){8}-?\\d\\.\\d$";
        return dataLine.matches(coordinatesRegExp);
    }
}
