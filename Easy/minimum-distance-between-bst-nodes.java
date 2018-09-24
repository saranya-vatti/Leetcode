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
    public int minDiffInBST(TreeNode root) {
        if(root.left == null && root.right == null) {
            return Integer.MAX_VALUE;
        }
        if(root.left == null) {
            int immediateHigher = leftMost(root.right);
            int rightAns = minDiffInBST(root.right);
            return Math.min(immediateHigher - root.val, rightAns);
        }
        if(root.right == null) {
            int immediateLower = rightMost(root.left);
            int leftAns = minDiffInBST(root.left);
            return Math.min(root.val - immediateLower, leftAns);
        }
        int immediateLower = rightMost(root.left);
        int immediateHigher = leftMost(root.right);
        int leftAns = minDiffInBST(root.left);
        int rightAns = minDiffInBST(root.right);
        int minWithRoot = Math.min(root.val - immediateLower, immediateHigher - root.val);
        int minWithoutRoot = Math.min(leftAns, rightAns);
        return Math.min(minWithRoot, minWithoutRoot);
    }
    private int rightMost(TreeNode root) {
        while(root.right != null) root=root.right;
        return root.val;
    }
    private int leftMost(TreeNode root) {
        while(root.left != null) root=root.left;
        return root.val;
    }
}
