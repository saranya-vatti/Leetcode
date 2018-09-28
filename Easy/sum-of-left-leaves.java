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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        return helper(root.left, true) + helper(root.right, false);
    }
    private int helper(TreeNode root, boolean isLeftChild) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            if(isLeftChild) return root.val;
            return 0;
        }
        return helper(root.left, true) + helper(root.right, false);
    }
}
