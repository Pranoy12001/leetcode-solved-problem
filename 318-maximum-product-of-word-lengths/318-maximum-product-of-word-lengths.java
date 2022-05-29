class Solution {
    public int maxProduct(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        
        int len = words.length;
        int[] state = new int[len];
        
        for (int i = 0; i < len; i++) {
            state[i] = getStateFromString(words[i]);
        }
        
        int maxProduct = 0;
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((state[i] & state[j]) == 0) {
                    if (words[i].length() * words[j].length() > maxProduct) {
                        maxProduct = words[i].length() * words[j].length();
                    }
                }
            }
        }
        
        return maxProduct;
    }
    
    private int getStateFromString(String word) {
        int state = 0;
        
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            state |= 1 << index;
        }
        
        return state;
    }
}