class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i - 1]);
        }
        list.add(nums[nums.length - 1]);
        int ans = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if ((list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) 
                || (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1))) {
                    ans++;
                }
        }
                
        return ans;
    }
}