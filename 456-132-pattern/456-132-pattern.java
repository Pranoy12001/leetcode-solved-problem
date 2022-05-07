class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        
        if (len < 3) {
            return false;
        }
        
        TreeMap<Integer, Integer> rightMap = new TreeMap<>();
        
        for (int i = 2; i < nums.length; i++) {
            rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);
        }
        
        int leftValue = nums[0];
        for (int j = 1; j < nums.length - 1; j++) {
            if (leftValue < nums[j]) {
                Integer numK = rightMap.ceilingKey(leftValue + 1);
                
                if (Objects.nonNull(numK) && numK < nums[j]) {
                    return true;
                }
            }
            
            leftValue = Math.min(leftValue, nums[j]);
            rightMap.put(nums[j + 1], rightMap.get(nums[j + 1]) - 1);
            
            if (rightMap.get(nums[j + 1]) == 0) {
                rightMap.remove(nums[j + 1]);
            }
        }
        
        return false;
    }
}