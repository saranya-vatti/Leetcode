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
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if(root == null) return sum;
        if(root.val > R) {
            sum += rangeSumBST(root.left, L, R);
        }
        if(root.val < L) {
            sum += rangeSumBST(root.right, L, R);
        }
        if(L <= root.val && root.val <= R) {
            sum+=root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
        return sum;
    }
}
