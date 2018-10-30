package com.ten_experts.Summatra.array;


/**
 * <pre>
 * Sum all elements in array
 *
 * @see com.ten_experts.Summatra.array.IArraySummater
 * </pre>
 * @since             1.0
 */
public class SimpleSummater implements IArraySummater {

    /**
     * Get sum of all elements in integer array
     *
     * <p>Method {@link #sum(int[] array)} sum up  all elements in array, then return value of sum created this way
     * @param array array of integer elements(array won't be changed after sum method)
     * @return            value of summed elements of  array
     * @throws ArraySummaterException throws if array is empty
     * @since             1.0
     */
    public int sum(int[] array) throws ArraySummaterException {
        if (array.length == 0) {
            throw new ArraySummaterException("Error!Array is empty!");
        }
        int result = 0;
        for (int element:array
             ) {
            result += element;
        }
        return result;
    }
}
