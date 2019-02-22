package com.epam.tetraider.generator;

import com.epam.tetraider.generator.interfaces.Generator;

public class IncrementalGenerator implements Generator<Integer> {
    private Integer last = 0;

    @Override
    public Integer generateNext() {
        return last++;
    }
}
