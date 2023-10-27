package Binary.Easy;

/*
    Question: https://leetcode.com/problems/number-of-1-bits/solutions/
    Solution: https://leetcode.com/problems/number-of-1-bits/solutions/3186879/java-easy-and-explained-solution-speed-beats-100/
    Time Complexity: O(n) where n is the number of binary digits in a number.
    Space Complexity: O(1)
*/
public class FindNumberOfOccurenceOfOnesInBinary {

    private static int getNumberOfOccurences(int binaryNumber) {
        int numberOfOccurences = 0;
        while (binaryNumber != 0) {
            if ((binaryNumber & 1) == 1) {
                numberOfOccurences += 1;
            }
            binaryNumber = binaryNumber >>> 1;
        }
        return numberOfOccurences;
    }

    public static void main(String[] args) {
        final int binaryNumber = 7;
        System.out.printf("Number of 1 digits = %d", getNumberOfOccurences(binaryNumber));
    }
}