class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                capitalCount++;
            }
        }
        
        if (capitalCount == word.length()) {
            return true;
        } else if (capitalCount == 0) {
            return true;
        } else if (capitalCount == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            return true;
        } else {
            return false;
        }
    }
}