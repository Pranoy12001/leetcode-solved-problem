class Solution {
    public String largestMerge(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(p1 < word1.length() || p2 < word2.length()) {
            
            char c1 = p1 < word1.length() ? word1.charAt(p1) : 0;
            char c2 = p2 < word2.length() ? word2.charAt(p2) : 0; 
            
            if(c1 == c2) {
                if(word1.substring(p1).compareTo(word2.substring(p2)) > 0) {
                    c2 = 0;
                } else {
                    c1 = 0;
                }
            }
            
            if(c1 > c2) {
                sb.append(c1);
                p1++;
            } else {
                sb.append(c2);
                p2++;
            }
        }
        
        return sb.toString();
    }
}