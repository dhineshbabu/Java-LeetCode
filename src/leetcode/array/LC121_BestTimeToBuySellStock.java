package leetcode.array;

import java.util.Arrays;

public class LC121_BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];

        for(int i=1; i<prices.length; i++) {
            // check if current buyPrice is less than existing buy_price
            if(buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else {
                // else calculate the profit now and check if the new profit is higher than existing profit
                int currentProfit = prices[i] - buyPrice;
                // check the maximum and update the profit
                profit = Math.max(currentProfit, profit);
            }
        }

        return profit; // profit will be 0 if there is no profit. (e.g) if input array in descending order

    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println("Maximum profit is: " + maxProfit(nums));
    }
}
