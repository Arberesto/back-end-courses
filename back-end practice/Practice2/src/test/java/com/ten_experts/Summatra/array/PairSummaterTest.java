package com.ten_experts.Summatra.array;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class PairSummaterTest {
    private PairSummater pairSummater;

    @Before
    public void setUp() {
        this.pairSummater = new PairSummater();
    }

    @Test
    public void testPairSummaterNormalSituation1() throws ArraySummaterException {
        int[] array = {1, 2, 3, 4};
        assertEquals("Wrong!Should be 7", 7,this.pairSummater.sum(array));
    }
    @Test(expected = com.ten_experts.Summatra.array.ArraySummaterException.class)
    public void testPairSummaterOddArraySize() throws ArraySummaterException {
        int[] array = {1, 2, 3};
        assertEquals("Wrong!Should be 5", 5, this.pairSummater.sum(array));
    }

    @Test(expected = com.ten_experts.Summatra.array.ArraySummaterException.class)
    public void testPairSummaterEmptyArray() throws ArraySummaterException {
        int[] array = {};
        assertEquals("Wrong!Should be 0", 0, this.pairSummater.sum(array));
    }
}
