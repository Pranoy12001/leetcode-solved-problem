class Solution {
    public String removeDuplicates(String s) {
        int i = 0;
        char[] charArray = new char[s.length()];
        
        for (int j = 0; j < s.length(); j++) {
            if (i > 0 && charArray[i - 1] == s.charAt(j)) {
                i--;
            } else {
                charArray[i] = s.charAt(j);
                i++;
            }
        }
        
        return new String(charArray, 0, i);
    }
}