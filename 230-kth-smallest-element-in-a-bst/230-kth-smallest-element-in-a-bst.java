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
    public int kthSmallest(TreeNode root, int k) {
        int[] result = {0, -1};
        inorderSolve(root, k, result);
        return result[1];
    }
    
    public void inorderSolve(TreeNode root, int k, int[] result) {
        if(root == null) {
            return;
        }
        
        inorderSolve(root.left, k, result);
        result[0]= result[0] + 1; 
        
        if(result[0] == k) {
            result[1]= root.val;
            return;
        }
        
        inorderSolve(root.right, k, result);
        return;
    }
}