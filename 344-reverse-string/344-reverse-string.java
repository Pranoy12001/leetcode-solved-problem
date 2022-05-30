class Solution {
    public void reverseString(char[] s) {
       if (s.length < 2) return;
       int start = 0;
       int end = s.length - 1;
        
        while (start < end) {
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            start++;
            end--;
        }
    }
}