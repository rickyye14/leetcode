public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[] forward = new int[n];
        forward[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < n; ++i) {
            minPrice = Math.min(minPrice, prices[i]);
            forward[i] = Math.max(prices[i] - minPrice, forward[i - 1]);
        }
        int[] back = new int[n];
        back[n - 1] = 0;
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            maxPrice = Math.max(maxPrice, prices[i]);
            back[i] = Math.max(maxPrice - prices[i], back[i + 1]);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; ++i) {
            maxProfit = Math.max(maxProfit, forward[i] + back[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII solver = new BestTimeToBuyAndSellStockIII();
        int[] prices = null;

        prices = new int[] {1, 2};
        System.out.println(solver.maxProfit(prices));
    }
}
