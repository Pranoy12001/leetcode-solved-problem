class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans; 
    }
    
    
    private void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] vis) {
        if(nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
		
        for(int i=0;i<nums.length; i++) {
		
            if(vis[i]) continue;
            if(i > 0 && ! vis[i-1] && nums[i] == nums[i-1]) continue;
            
            vis[i] = true;
            temp.add(nums[i]);
            
            helper(ans, temp, nums, vis); 
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }
}