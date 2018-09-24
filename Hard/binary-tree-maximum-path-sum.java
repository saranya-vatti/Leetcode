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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int maxLeft = maxPathSum(root.left);
        int maxRight = maxPathSum(root.right);
        int maxLeftWithRoot = maxPathSumRoot(root.left);
        int maxRightWithRoot = maxPathSumRoot(root.right);
        if(root.left == null) {
            return max(maxRight, maxRightWithRoot+root.val, root.val);
        }
        if(root.right == null) {
            return max(maxLeft, maxLeftWithRoot+root.val, root.val);
        }
        return Math.max(max(maxLeft, maxRight, max(maxRightWithRoot+root.val, root.val+maxLeftWithRoot, maxRightWithRoot+root.val+maxLeftWithRoot)), root.val);
    }
    private int maxPathSumRoot(TreeNode root) {
        if(root == null) return 0;
        return root.val + max(maxPathSumRoot(root.left), maxPathSumRoot(root.right), 0);
    }
    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b,c));
    }
}
