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
    int camera = 0;
    public int minCameraCover(TreeNode root) {
        if(getCamera(root) == -1) {
            camera++;
        }
        
        return camera;
    }
    
    
    public int getCamera(TreeNode root){
        if(root == null) {
            return 0;
        }
            
        int left = getCamera(root.left);
        int right = getCamera(root.right);
        
        if(left == 0 && right == 0) {
            return -1;
        }
            
        if(left == -1 || right == -1){
            camera++;
            return 1;
        }
        
        return 0;
    }
}