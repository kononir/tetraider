package com.epam.tetraider.sorting;

import com.epam.tetraider.model.NumberedTetrahedron;

import java.util.Comparator;
import java.util.List;

public class Sorter {
    private Comparator<NumberedTetrahedron> sortingMethod;

    public Sorter(Comparator<NumberedTetrahedron> sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    public void sort(List<NumberedTetrahedron> list) {
        list.sort(sortingMethod);
    }
}
