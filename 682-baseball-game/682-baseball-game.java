class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        
        for (String s : ops) {
            if (s.equals("+")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second);
                stack.push(first);
                stack.push(first + second);
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        
        int sum = 0;
        
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        
        return sum;
    }
}