package Array.Medium;

/*
    Question: https://leetcode.com/problems/container-with-most-water/
    Solution: https://www.code-recipe.com/post/container-with-most-water
    Time Complexity: O(n)
    Space Complexity: O(1)
*/

public class ContainerWithMostWater {

    private static int getMaximumContainer(final int[] numbers) {
        int startingIndex = 0;
        int endingIndex = numbers.length - 1;
        int maximumStorageContainer= 0;

        while(startingIndex!=endingIndex) {
            final int heightOfContainer = Math.min(numbers[startingIndex], numbers[endingIndex]);
            final int lengthOfContainer = endingIndex - startingIndex;
            final int storageOfContainer = heightOfContainer * lengthOfContainer;

            maximumStorageContainer = Math.max(storageOfContainer, maximumStorageContainer);

            if(numbers[startingIndex] < numbers[endingIndex]) {
                startingIndex += 1;
            } else {
                endingIndex -= 1;
            }
        }

        return maximumStorageContainer;
    }

    public static void main(String[] args) {
        final int[] numbers = {1,8,6,2,5,4,8,3,7};
        if (numbers.length <= 1) {
            System.out.println("No QUANTITY OF WATER CAN BE STORED.");
        }
        System.out.println(getMaximumContainer(numbers));
    }
}
