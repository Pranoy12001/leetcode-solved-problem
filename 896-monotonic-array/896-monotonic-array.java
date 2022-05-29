class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increment = true;
        boolean decrement = true;
        
        for (int i = 1; i < nums.length; i++) {
            increment &= nums[i - 1] <= nums[i];
            decrement &= nums[i - 1] >= nums[i];
        }
        
        return increment || decrement;
    }
}