package com.ten_experts.Summatra.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PairSummaterTest {
    private PairSummater pairSummater;

    @Before
    public void setUp() {
        this.pairSummater = new PairSummater();
    }

    @Test
    public void testPairSummater1() {
        int[] array = {1, 2, 3, 4};
        int result = 0;
        try {
            result = this.pairSummater.sum(array);
        }
        catch (ArraySummaterException e){
            System.out.println(e.getMessage());
        }
        assertArrayEquals("Wrong!Should be 7",
                7, result);
    }
    @Test(expected = ArraySummaterException.class)
    public void testPairSummater2() {
        int[] array = {1, 2, 3};
        try {
            int result = this.pairSummater.sum(array);
        }
        catch (ArraySummaterException e){
            System.out.println(e.getMessage());
        }
        assertArrayEquals("Wrong!Should be 7",
                7, result);
    }
}
