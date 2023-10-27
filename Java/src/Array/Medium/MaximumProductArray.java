package Array.Medium;

/*
    Question: https://leetcode.com/problems/maximum-product-subarray/
    Solution: Modified version of Kadanes algorithm used in MaximumSubarray problem.
    Time Complexity: O(n)
    Space Complexity: O(1)
*/

import java.util.Arrays;

public class MaximumProductArray {
    private static int getMaxProductArray(final int[] numbers) {
        int globalMaximum = numbers[0];
        int currentMinimum = 1;
        int currentMaximum = 1;
        for(int i=0;i< numbers.length;i++) {
            final int values[] = {numbers[i], numbers[i] * currentMinimum, numbers[i] * currentMaximum};
            currentMinimum = Arrays.stream(values).min().getAsInt();
            currentMaximum = Arrays.stream(values).max().getAsInt();
            globalMaximum = Math.max(currentMaximum, globalMaximum);
        }
        return globalMaximum;
    }

    public static void main(String[] args) {
        final int[] numbers = {2,3,-2,4};
        System.out.println(getMaxProductArray(numbers));
    }
}
