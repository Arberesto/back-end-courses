package com.ten_experts.Summatra.array;


/**
 * <pre>
 * Sum elements in array in some way
 *
 * @see com.ten_experts.Summatra.array.IArraySummater
 * </pre>
 * @since             1.0
 */
public interface IArraySummater {
    /**
     * Get summary of array's elements
     *
     * <p>This method somehow sum elements in array
     * @param array array of elements(array won't be changed after sum method)
     * @return            value of sum created in this method
     * @throws ArraySummaterException throws if array is empty
     * @since             1.0
     */
    int sum(int[] array) throws ArraySummaterException;
}
