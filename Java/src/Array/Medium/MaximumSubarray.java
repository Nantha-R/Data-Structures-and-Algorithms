package Array.Medium;

/*
    Question: https://leetcode.com/problems/maximum-subarray/
    Solution: https://leetcode.com/problems/maximum-subarray/discuss/1830487/kandane-algo-oror-java-oror-easy-approach-oror-comments-oror-easy-understanding
    Time Complexity: O(n)
    Space Complexity: O(1)
*/
public class MaximumSubarray {
    private static int getMaxSumArray(final int[] numbers) {
        int curSum = numbers[0];
        int maxSum = numbers[0];
        for(int i=1;i<numbers.length;i++) {
            curSum = Math.max(curSum + numbers[i], numbers[i]);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    public static void main(final String[] args) {
        final int[] numbers = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(getMaxSumArray(numbers));
    }
}
