package com.ten_experts.Summatra.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleSummaterTest {
    private SimpleSummater simpleSummater;

    @Before
    public void setUp() {
        this.simpleSummater = new SimpleSummater();
    }

    @Test
    public void testSimpleSummaterNormalSituation1() throws ArraySummaterException {
        int[] array = {1, 2, 3, 4};
        assertEquals("Wrong!Should be 10", 10,this.simpleSummater.sum(array));
    }
    @Test
    public void testSimpleSummaterSingleElement() throws ArraySummaterException {
        int[] array = {1};
        assertEquals("Wrong!Should be 1", 1, this.simpleSummater.sum(array));
    }

    @Test(expected = com.ten_experts.Summatra.array.ArraySummaterException.class)
    public void testSimpleSummaterEmptyArray() throws ArraySummaterException {
        int[] array = {};
        assertEquals("Wrong!Should be 0", 0, this.simpleSummater.sum(array));
    }
}
