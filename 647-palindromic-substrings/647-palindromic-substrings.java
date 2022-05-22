class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int d = 0; d < s.length(); d++) {
            for (int i =0, j = d; j < dp.length; j++, i++) {
                if (d == 0) {
                    dp[i][j] = true;
                } else if (d == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j -1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                
                if (dp[i][j] == true) {
                    count++;
                }
            }
            
        }
        
        return count;
    }
}