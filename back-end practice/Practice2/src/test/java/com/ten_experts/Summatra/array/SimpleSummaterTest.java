package com.ten_experts.Summatra.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SimpleSummaterTest {
    private SimpleSummater simpleSummater;

    @Before
    public void setUp() {
        this.simpleSummater = new SimpleSummater();
    }

    @Test
    public void testSimpleSummaterNormalSituation1() {
        int[] array = {1, 2, 3, 4};
        int[] expectedResultArray = {7};
        int[] resultArray = new int[1];
        try {
            resultArray[0] = this.simpleSummater.sum(array);
        }
        catch (ArraySummaterException e){
            System.out.println(e.getMessage());
        }
        assertArrayEquals("Wrong!Should be 7", expectedResultArray,resultArray);
    }
    @Test(expected = ArraySummaterException.class)
    public void testSimpleSummaterEvenArraySize() {
        int[] array = {1, 2, 3};
        int[] expectedResultArray = {7};
        int[] resultArray = new int[1];
        try {
            resultArray[0] = this.simpleSummater.sum(array);
        }
        catch (ArraySummaterException e){
            System.out.println(e.getMessage());
        }
        assertArrayEquals("Wrong!Should be 7", expectedResultArray, resultArray);
    }

    @Test(expected = ArraySummaterException.class)
    public void testSimpleSummaterEmptyArray() {
        int[] array = {};
        int[] expectedResultArray = {0};
        int[] resultArray = new int[1];
        try {
            resultArray[0] = this.simpleSummater.sum(array);
        }
        catch (ArraySummaterException e){
            System.out.println(e.getMessage());
        }
        assertArrayEquals("Wrong!Should be 0", expectedResultArray, resultArray);
    }
}
