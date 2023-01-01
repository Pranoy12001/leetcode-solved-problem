class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        
        Map<Character, String> charToString = new HashMap<>();
        Map<String, Character> stringToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if (!charToString.containsKey(ch)) {
               charToString.put(ch, word); 
            }
            
            if (!stringToChar.containsKey(word)) {
               stringToChar.put(word, ch); 
            }
            
            if (!charToString.get(ch).equals(word) || !stringToChar.get(word).equals(ch)) {
                return false;
            }
        }
        
        return true;
    }
}