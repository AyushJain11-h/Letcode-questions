class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int hold = -prices[0]; // buying stock
        int sold = 0;          // just sold
        int rest = 0;          // cooldown / do nothing

        for (int i = 1; i < prices.length; i++) {
            int prevSold = sold;

            sold = hold + prices[i];            // sell today
            hold = Math.max(hold, rest - prices[i]); // buy or keep holding
            rest = Math.max(rest, prevSold);    // cooldown or stay idle
        }

        return Math.max(sold, rest);
    }
}