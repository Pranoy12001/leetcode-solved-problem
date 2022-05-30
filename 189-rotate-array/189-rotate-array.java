class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (nums.length == 0 || k == 0) {
            return;
        }
        int len = nums.length - 1;
        reverse(nums, 0, len);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}