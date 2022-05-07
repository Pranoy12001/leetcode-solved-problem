class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        
        if (len < 3) {
            return false;
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        int k = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (k > 0 && nums[k] > nums[i]) {
                return true;
            }
            
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                k = stack.pop();
            }
            
            stack.push(i);
        }
        
        return false;
    }
}