class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int odd = 0;
        int even = nums.length - 1;
        
        while(odd < even) {
            while (odd < even && nums[odd] % 2 == 0) {
                odd++;
            }
            
            while (odd < even && nums[even] % 2 != 0) {
                even--;
            }
            
            if (odd < even) {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                odd++;
                even--;
            }
        }
        
       return nums;
    }
}