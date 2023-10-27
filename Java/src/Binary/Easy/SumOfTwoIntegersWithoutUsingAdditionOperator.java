package Binary.Easy;

/*
    Question: https://leetcode.com/problems/sum-of-two-integers/
    Solution: https://leetcode.com/problems/sum-of-two-integers/solutions/132479/simple-explanation-on-how-to-arrive-at-the-solution/
    Time Complexity: O(1)
    Space Complexity: O(1)
*/

public class SumOfTwoIntegersWithoutUsingAdditionOperator {

  private static int getSum(int integerOne, int integerTwo) {
    while(integerTwo != 0) {
      final int carry = integerOne & integerTwo;
      integerOne = integerOne ^ integerTwo;
      integerTwo = carry << 1;
    }
    return integerOne;
  }

  public static void main(String[] args) {
    final int integerOne = 3;
    final int integerTwo = 7;
    System.out.printf("SUM = %d", getSum(integerOne,integerTwo));
  }
}