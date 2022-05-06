class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            
            if (stack.isEmpty()) {
                stack.push(new Pair<>(ch, 1));
            } else {
                Pair<Character, Integer> pair = stack.peek();
                
                if (pair.getKey() == ch) {
                    stack.pop();
                    stack.push(new Pair<>(ch, pair.getValue() + 1));
                } else {
                    stack.push(new Pair<>(ch, 1));
                }
                
                Pair<Character, Integer> p = stack.peek();
                
                if (p.getValue() == k) {
                    stack.pop();
                }
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for (Pair<Character, Integer> p : stack) {
            Integer value = p.getValue();
            
            while (value > 0) {
                sb.append(p.getKey());
                value--;
            }
        }
        
        return sb.toString();
    }
}