class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m + 1][n + 1][strs.length];
        return helper(strs, m, n, 0);
    }
    
    int helper(String[] strs, int m, int n, int index) {
        if (index == strs.length || m + n == 0) {
            return 0;
        }
        
        if (dp[m][n][index] > 0) {
            return dp[m][n][index];
        }
        
        int accept = 0;
        int[] count = count(strs[index]);
        if (m >= count[0] && n >= count[1]) {
            accept = 1 + helper(strs, m - count[0], n - count[1], index + 1);
        }
        
        int reject = helper(strs, m, n, index + 1);
        
        dp[m][n][index] = Math.max(accept, reject);
        
        return dp[m][n][index];
    }
    
    int[] count(String str) {
        int[] count = new int[2];
        
        for (char ch : str.toCharArray()) {
            count[ch - '0']++;
        }
        
        return count;
    }
}