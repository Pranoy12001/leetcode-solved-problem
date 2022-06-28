class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] psum = new long[nums.length + 1];
        
        for (int i = 0; i < n; i++) {
            psum[i + 1] = psum[i] + nums[i];
        }
        
        int[] smallerOnLeft = nextSmallerElementInLeft(nums);
        int[] smallerOnRight = nextSmallerElementInRight(nums);
        
        long max = Long.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int lr = smallerOnLeft[i];
            int rr = smallerOnRight[i];
            
            long sum = psum[rr] - psum[lr + 1];
            long minProduct = sum * min;
            max = Math.max(max, minProduct);
        }
        
        return (int)(max % 1000000007);
    }
    
    public static int[] nextSmallerElementInLeft(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        
        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() > 0 && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            
            if (stack.size() == 0) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        return result;
    }
    
    public static int[] nextSmallerElementInRight(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        
        int[] result = new int[nums.length];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            
            if (stack.size() == 0) {
                result[i] = nums.length;
            } else {
                result[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        return result;
    }
}