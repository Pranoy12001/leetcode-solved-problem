class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList();
        int i = 0;
        int j = 0;
        while(i++ <= n && j < target.length) {
            list.add("Push");
            if(target[j] == i) j++;
            else list.add("Pop");
        }
        
        return list;
    }
}