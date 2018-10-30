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
    public void testPairSummaterNormalSituation1() {
        int[] array = {1, 2, 3, 4};
        int[] expectedResultArray = {7};
        int[] resultArray = new int[1];
        try {
            resultArray[0] = this.pairSummater.sum(array);
        }
        catch (ArraySummaterException e){
            System.out.println(e.getMessage());
        }
        assertArrayEquals("Wrong!Should be 7", expectedResultArray,resultArray);
    }
    @Test(expected = ArraySummaterException.class)
    public void testPairSummaterEvenArraySize() {
        int[] array = {1, 2, 3};
        int[] expectedResultArray = {7};
        int[] resultArray = new int[1];
        try {
            resultArray[0] = this.pairSummater.sum(array);
        }
        catch (ArraySummaterException e){
            System.out.println(e.getMessage());
        }
        assertArrayEquals("Wrong!Should be 7", expectedResultArray, resultArray);
    }

    @Test(expected = ArraySummaterException.class)
    public void testPairSummaterEmptyArray() {
        int[] array = {};
        int[] expectedResultArray = {0};
        int[] resultArray = new int[1];
        try {
            resultArray[0] = this.pairSummater.sum(array);
        }
        catch (ArraySummaterException e){
            System.out.println(e.getMessage());
        }
        assertArrayEquals("Wrong!Should be 0", expectedResultArray, resultArray);
    }
}
