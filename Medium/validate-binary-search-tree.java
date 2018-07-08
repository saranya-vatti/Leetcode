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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left != null && (root.left.val >= root.val || max(root.left) >= root.val)) return false;
        if(root.right != null && (root.right.val <= root.val || root.val >= min(root.right))) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
    public int max(TreeNode root) {
        while(root.right!=null) root = root.right;
        return root.val;
    }
    public int min(TreeNode root) {
        while(root.left!=null) root = root.left;
        return root.val;
    }
}