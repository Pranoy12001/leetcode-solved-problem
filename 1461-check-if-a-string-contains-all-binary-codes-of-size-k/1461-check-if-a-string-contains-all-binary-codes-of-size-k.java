class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < s.length() - k + 1; i++) {
            set.add(s.substring(i, k + i));
        }
        
        return Math.pow(2, k) == set.size();
    }
}