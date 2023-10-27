package Array.Easy;

/*
    Question: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    Solution: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/1735493/JavaC%2B%2B-best-ever-EXPLANATION-could-possible
    Time Complexity: O(n)
    Space Complexity: O(1)
*/

import java.lang.Math;

public class BestTimeToBuyAndSellStock{
  private static int getMaximumProfit(final int[] stockPrices) {
    int minimumValue = stockPrices[0];
    int maximumProfit = 0;
    for (int i=1; i<stockPrices.length;i++) {
      if (stockPrices[i] > minimumValue) {
        final int currentProfit = stockPrices[i] - minimumValue;
        maximumProfit = Math.max(currentProfit, maximumProfit);
      }
      minimumValue = Math.min(minimumValue, stockPrices[i]);
    }
    return maximumProfit;
  }

  public static void main(String[] args) {
    final int[] stockPrices = {7,1,5,3,6,4};
    final int profit = getMaximumProfit(stockPrices);
    System.out.println(profit);
  }
}
