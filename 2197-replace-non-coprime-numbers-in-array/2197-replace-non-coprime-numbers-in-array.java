class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            while(stack.size() > 0 && gcd(stack.peek(), nums[i]) > 1) {
                int val = stack.pop();
                nums[i] = (val / gcd(val, nums[i])) * nums[i];
            } 
            stack.push(nums[i]);
            
        }
        List<Integer> result = new ArrayList<>();
        while(stack.size() > 0) {
            result.add(stack.pop());
        }
        Collections.reverse(result);
        return result;
    }
    
    public int gcd(int a, int b) {
        while(b % a != 0) {
            int val = a;
            a = b % a;
            b = val;
        }
        return a;
    }
}