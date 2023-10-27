package Array.Medium;

/*
    Question: https://leetcode.com/problems/product-of-array-except-self/
    Solution: https://leetcode.com/problems/product-of-array-except-self/discuss/1597994/C%2B%2B-3-Simple-Solutions-w-Explanation-or-Prefix-and-Suffix-product-O(1)-space-approach
    Time Complexity: O(n)
    Space Complexity: O(1)
*/

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    /*
        Time Complexity: O(2n)
        Space Complexity: O(2n)
    */
    private static int[] getProductArray(final int[] numbers, final int n) {
        // Create a prefix product array. [1,2,3,4] -> [1,1,2,6]
        final int[] prefixProductArray = new int[n];
        prefixProductArray[0] = 1;
        int prefixProduct = numbers[0];
        for(int i=1;i<n;i++) {
            prefixProductArray[i] = prefixProduct;
            prefixProduct = prefixProduct * numbers[i];
        }

        // Create a Suffix product array. [1,2,3,4] -> [1,4,12,24]
        final int[] suffixProductArray = new int[n];
        suffixProductArray[0] = 1;
        int suffixProduct = numbers[n-1];
        int insertion_index = 1;
        for(int i=n-2;i>=0;i--) {
            suffixProductArray[insertion_index] = suffixProduct;
            suffixProduct = suffixProduct * numbers[i];
            insertion_index += 1;
        }

        // Add Prefix and Suffix products, Iterating prefix product array from 0 to n and iterating suffix product array from n to 0.
        final int[] productArray = new int[n];
        for (int i=0; i<n;i++) {
            final int prefixElement = prefixProductArray[i];
            final int suffixElement = suffixProductArray[n-1-i];
            productArray[i] = prefixElement * suffixElement;
        }
        return productArray;
    }

    /*
        Time Complexity: O(n)
        Space Complexity: O(1)
    */
    private static int[] getProductArrayV2(final int[] numbers, final int n) {
        // Calculate prefix products. [1,2,3,4] -> [1,1,2,6]
        // Calculate Suffix products. [1,2,3,4] -> [1,4,12,24]
        int prefixProduct = 1;
        int suffixProduct = 1;
        final int[] productArray = new int[n];
        Arrays.fill(productArray, 1);
        for (int i=0;i<n;i++) {
            // Prefix values should be muliplied from 0 to n.
            productArray[i] = productArray[i] * prefixProduct;
            // Suffix values should be multiplied from n-1 to 0.
            productArray[n-1-i] = productArray[n-1-i] * suffixProduct;
            prefixProduct = prefixProduct * numbers[i];
            suffixProduct = suffixProduct * numbers[n-1-i];
        }
        return productArray;
    }

    public static void main(String[] args) {
        final int[] numbers = {1,2,3,4};
        System.out.println(Arrays.toString(getProductArray(numbers, numbers.length)));
        System.out.println(Arrays.toString(getProductArrayV2(numbers, numbers.length)));
    }
}
