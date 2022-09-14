/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) return ans;
        Map<Integer, Integer> map = new HashMap<>();
        preparePseudoPalindromicPaths(root, map);
        return ans;
    }
    
    private void preparePseudoPalindromicPaths(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        
        if (root.left == null && root.right == null) {
            int oddCount = 0;
            for (int i = 0; i <= 9; i++) {
                if (map.containsKey(i) && map.get(i) % 2 != 0) {
                    oddCount++;
                }
            }
            
            if (oddCount <= 1) {
                ans++;
            }
        }
        
        preparePseudoPalindromicPaths(root.left, map);
        preparePseudoPalindromicPaths(root.right, map);
        
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) - 1);
        }
    }
}