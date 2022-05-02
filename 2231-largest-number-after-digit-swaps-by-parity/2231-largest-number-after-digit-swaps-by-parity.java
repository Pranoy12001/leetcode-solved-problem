class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        PriorityQueue<Integer> even = new PriorityQueue<>();
        
        int tempNum = num;
        
        while (tempNum > 0) {
            int cur = tempNum % 10;
            
            if (cur % 2 == 0) {
                even.add(cur);
            } else {
                odd.add(cur);
            }
            
            tempNum /= 10;
        }
        
        StringBuffer sb = new StringBuffer();
        
        while (num > 0) {
            int cur = num % 10;
            
            if (cur % 2 == 0) {
                sb.append(even.poll());
            } else {
                sb.append(odd.poll());
            }
            num /= 10;
        }
        
        sb.reverse();
        
        return Integer.valueOf(sb.toString());
    }
}