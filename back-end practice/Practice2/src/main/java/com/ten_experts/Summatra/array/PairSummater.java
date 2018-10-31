package com.ten_experts.Summatra.array;



/**
 * <pre>
 * Sum up elements in pairs
 * </pre>
 * @see com.ten_experts.Summatra.array.IArraySummater
 * @since             1.0
 */

public class PairSummater implements IArraySummater  {
    /**
     * Get max sum of pair in integer array
     *
     *
     *
     *
     * <p>Method  up elements in pairs, then return value of maximum pair created this way
     * @param array array of integer elements(array won't be changed after sum method)
     * @return            value of summed pair of array's elements that created in this method
     * @throws ArraySummaterException throws if array is empty or number of elements in array are odd
     * @since             1.0
     */
    public int sum(final int[] array) throws ArraySummaterException {
        if (array.length == 0) {
            throw new ArraySummaterException("Error!Array is empty!");
        }
        if (array.length % 2 != 0) {
            throw new ArraySummaterException("Error!Use even number of elements in array.");
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[2 * i] + array[2 * i + 1];
            if (result < temp) {
                result = temp;
            }
        }
        return result;
    }
}
