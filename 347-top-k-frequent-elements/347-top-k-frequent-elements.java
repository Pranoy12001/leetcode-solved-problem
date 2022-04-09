class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 1 + map.get(num));
            } else {
                map.put(num, 1);
            }
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}