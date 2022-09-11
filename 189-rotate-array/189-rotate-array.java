class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (n == 0 || k == 0) return;
        
        reserse(nums, 0, n - 1);
        reserse(nums, 0, k - 1);
        reserse(nums, k, n - 1);
    }
    
    private void reserse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start++;
            end--;
        }
    }
}