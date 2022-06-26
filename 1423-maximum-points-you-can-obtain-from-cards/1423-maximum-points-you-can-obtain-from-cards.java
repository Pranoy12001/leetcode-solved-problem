class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        for (int i = 0; i < n; i++) {
            sum += cardPoints[i];
        }
        
        if (n == k) return sum;
        
        int temp = 0;
        int result = 0;
        
        for (int i = 0; i < n - k - 1; i++) {
            temp += cardPoints[i];
        }
        
        for (int i = n - k - 1; i < n; i++) {
            temp += cardPoints[i];
            result = Math.max(sum - temp, result);
            temp -= cardPoints[i - (n - k - 1)];
        }
        
        return result;
    }
}