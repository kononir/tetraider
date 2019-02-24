package com.epam.tetraider.sorting.comparators.tetrahedron.id;

import com.epam.tetraider.model.tetrahedron.NumberedTetrahedron;

import java.util.Comparator;

public class IDComparator implements Comparator<NumberedTetrahedron> {

    @Override
    public int compare(NumberedTetrahedron o1, NumberedTetrahedron o2) {
        int id1 = o1.getId();
        int id2 = o2.getId();

        return id1 - id2;
    }
}
