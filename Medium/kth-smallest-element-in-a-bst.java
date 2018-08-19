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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        int rank = size(root.left) + 1;
        if(rank == k) return root.val;
        if(rank < k) return kthSmallest(root.right, k - rank);
        return kthSmallest(root.left, k);
    }
    private int size(TreeNode root) {
        if(root == null) return 0;
        return size(root.left) + 1 + size(root.right);
    }
}
