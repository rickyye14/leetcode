public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxDiff = 0;
        for (int i = 1; i < n; ++i) {
            int diff = prices[i] - minPrice;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxDiff;
    }
}
