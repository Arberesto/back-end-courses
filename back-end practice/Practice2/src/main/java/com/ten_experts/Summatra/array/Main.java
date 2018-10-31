package com.ten_experts.Summatra.array;

/**
 * Entry point for program
 */

final class Main {

    private Main(){}
    /**
     *Starting method
     * @param args - arguments in command line for app(currently not used)
     */
    public static void main(final String[] args) {
        PairSummater pairSum = new PairSummater();
        SimpleSummater simpleSum = new SimpleSummater();
        int[] array1 = {1, 2 , 3};
        int[] array2 = {8, 20, 10, 50, 9 , 31};
        try {
            System.out.println(pairSum.sum(array1));
        } catch (ArraySummaterException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(pairSum.sum(array2));
        } catch (ArraySummaterException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(simpleSum.sum(array2));
        } catch (ArraySummaterException e) {
            System.out.println(e.getMessage());
        }
    }
}
