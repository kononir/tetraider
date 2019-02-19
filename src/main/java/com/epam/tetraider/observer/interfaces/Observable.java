package com.epam.tetraider.observer.interfaces;

import com.epam.tetraider.model.NumberedTetrahedron;

public interface Observable<T extends NumberedTetrahedron> {
    void addObserver(Observer<T> observer);
}
