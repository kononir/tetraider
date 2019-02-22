package com.epam.tetraider.generator;

import com.epam.tetraider.generator.interfaces.Generator;
import org.junit.Assert;
import org.junit.Test;

public class IncrementalGeneratorTests {
    private static final Integer EXPECTED_ZERO = 0;
    private static final Integer EXPECTED_ONE = 1;

    @Test
    public void testGenerateNextShouldReturnZeroWhenLastIsZero() {
        // given
        Generator<Integer> generator = new IncrementalGenerator();

        // when
        Integer actual = generator.generateNext();

        // then
        Assert.assertEquals(EXPECTED_ZERO, actual);
    }

    @Test
    public void testGenerateNextShouldReturnOneWhenLastIsOne() {
        // given
        Generator<Integer> generator = new IncrementalGenerator();

        // when
        Integer zero = generator.generateNext();
        Integer one = generator.generateNext();

        // then
        Assert.assertEquals(EXPECTED_ZERO, zero);
        Assert.assertEquals(EXPECTED_ONE, one);
    }

}
