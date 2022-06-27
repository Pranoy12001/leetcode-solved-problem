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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return convertBstFromArray(nums, 0, nums.length - 1);
    }
    
    private TreeNode convertBstFromArray(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convertBstFromArray(nums, start, mid - 1);
        node.right = convertBstFromArray(nums, mid + 1, end);
        
        return node;
    }
}