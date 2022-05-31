class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] arr = new int[26];
        
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        
        int desiredNum = arr[s.charAt(0) - 'a'];
        for (int num : arr) {
           if (num == 0) continue;
            
            if (num != desiredNum) return false;
            
        }
        
        return true;
    }
}