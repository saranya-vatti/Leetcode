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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> parentList = new LinkedList<>();
        Queue<TreeNode> childList = new LinkedList<>();
        parentList.add(root);
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        while(!parentList.isEmpty()) {
            int currVal = Integer.MIN_VALUE;
            while(!parentList.isEmpty()) {
                TreeNode parent = parentList.remove();
                if (parent.val > currVal) {
                    currVal = parent.val;
                }
                if(parent.left != null) childList.add(parent.left);
                if(parent.right != null) childList.add(parent.right);
            }
            result.add(currVal);
            parentList = childList.clone();
            childList = new LinkedList<>();
        }
        return result;
    }
}