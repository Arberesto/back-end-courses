package com.ten_experts.Summatra.array;

public class SimpleSummater implements IArraySummater {
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
