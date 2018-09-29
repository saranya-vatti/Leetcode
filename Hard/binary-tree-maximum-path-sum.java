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
    int maxWithRoot = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxWithRoot;
    }
    private int maxPath(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));
        maxWithRoot = Math.max(left + right + root.val, maxWithRoot);
        return Math.max(left, right) + root.val;
    }
}
