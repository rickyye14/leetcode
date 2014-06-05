public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int sumProfit = 0;
        for (int start = 0, end = 1; start < n; start = end) {
            end = start + 1;
            for ( ; end < n && prices[end - 1] <= prices[end]; ++end) {
                ;
            }
            sumProfit += prices[end - 1] - prices[start];
        }
        return sumProfit;
    }
}
