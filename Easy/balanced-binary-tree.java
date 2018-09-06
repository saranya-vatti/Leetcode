/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int diff = height(root.left) - height(root.right);
        if(diff != 0 && diff != 1 && diff != -1) return false;
        if(!isBalanced(root.left)) return false;
        return isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
