class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        int ans = 0;
        
        for (int[] boxType : boxTypes) {
            if (boxType[0] < truckSize) {
                truckSize -= boxType[0];
                ans += (boxType[0] * boxType[1]);
            } else {
                ans += (truckSize * boxType[1]);
                break;
            }
        }
        
        return ans;
    }
}