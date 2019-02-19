package com.epam.tetraider.repository.interfaces;

public interface Specification<T> {
    boolean specified(T specifiedObject);
}
