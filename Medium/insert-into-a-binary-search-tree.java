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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        TreeNode parent = root;
        while(true) {
            if(val>=parent.val) {
                if(parent.right == null) {
                    parent.right = new TreeNode(val);
                    return root;
                }
                parent = parent.right;
            } else {
                if(parent.left == null) {
                    parent.left = new TreeNode(val);
                    return root;
                }
                parent = parent.left;
            }
        }
    }
}
