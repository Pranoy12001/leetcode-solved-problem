class Solution {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
          int target = k - num;
          if (freq.getOrDefault(target, 0) != 0) {
            ++result;
            freq.put(target, freq.get(target) - 1);
          } else {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
          }
        }
        return result;
    }
}