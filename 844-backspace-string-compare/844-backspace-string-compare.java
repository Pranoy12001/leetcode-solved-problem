class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
                continue;
            }
            
            sStack.push(ch);
        }
        
        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
                continue;
            }
            
            tStack.push(ch);
        }
        
        if (sStack.size() == tStack.size() && String.valueOf(sStack).equals(String.valueOf(tStack))) {
            return true;
        }
        
        return false;
    }
}