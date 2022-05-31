class Solution {
    public int countPoints(String rings) {
        int[] r = new int[10];
        int[] g = new int[10];
        int[] b = new int[10];
        
        for (int i = 0; i < rings.length(); i += 2) {
            int rodNum = rings.charAt(i + 1) - '0';
            
            if (rings.charAt(i) == 'R') {
                r[rodNum]++;
            } else if (rings.charAt(i) == 'G') {
                g[rodNum]++;
            } else {
                b[rodNum]++;
            }
        }
        
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (r[i] > 0 && g[i] > 0 && b[i] > 0) {
                count++;
            }
        }
        
        return count;
    }
}