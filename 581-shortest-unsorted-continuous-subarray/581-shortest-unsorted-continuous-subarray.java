class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length - 1, left = -1, right = -1,
            max = nums[0], min = nums[len];
        for (int i = 1; i <= len; i++) {
            int a = nums[i], b = nums[len-i];
            if (a < max) right = i;
            else max = a;
            if (b > min) left = i;
            else min = b;
        }
        return Math.max(0, left + right - len + 1);
    }
}