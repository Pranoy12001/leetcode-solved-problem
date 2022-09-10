class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[k + 1][prices.length];
        
        for (int i = 1; i <= k; i++) {
            for (int d = 1; d < n; d++) {
                int max = dp[i][d-1];
                
                for (int j = 0; j < d; j++) {
                    int a = dp[i - 1][j];
                    int b = prices[d] - prices[j];
                    
                    if (a + b > max) {
                        max = a + b;
                    }
                }
                
                dp[i][d] = max;
            }
        }
        
        return dp[k][n - 1];
    }
}