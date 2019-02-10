package com.epam.tetraider.exceptions;

public class FileIsEmptyException extends Exception {
    public FileIsEmptyException() {
        super("File is empty!");
    }
}
