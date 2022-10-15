class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int index = 0;
        int count = 1;
        int i = 1;
        for (; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                count++;
            } else {
                chars[index++] = chars[i - 1];
                if (count > 1) {
                    String s = String.valueOf(count);
                    
                    for (int j = 0; j < s.length(); j++) {
                        chars[index++] = s.charAt(j);
                    }
                }
                count = 1;
            }
        }
        chars[index++] = chars[i - 1];
        if (count > 1) {
            String s = String.valueOf(count);
            for (int j = 0; j < s.length(); j++) {
                chars[index++] = s.charAt(j);
            }
        }
        
        return index;
    }
}