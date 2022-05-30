class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0 || dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }        
        
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        
        int result = 0;
        
        while (a - b >= 0) {
            int x = 0;
            
            while (a - (b << 1 << x) >= 0) {
                x++;
            }
            
            result += 1 << x;
            
            a -= b << x;
        }
        
        return (dividend > 0) == (divisor > 0) ? result : -result;
    }
}