package com.ten_experts.Summatra.array;

public class PairSummater implements IArraySummater  {
    public int sum(int[] array) throws ArraySummaterException{
        if (array.length == 0){
            throw new ArraySummaterException("Error!Array is empty!");
        }
        if (array.length %2 != 0){
            throw new ArraySummaterException("Error!Use odd number of elements in array.");
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[2*i] + array[2*i +1];
            if (result < temp){
                result = temp;
            }
        }
        return result;
    }
}
