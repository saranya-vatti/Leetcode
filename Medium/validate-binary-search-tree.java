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
    Stack<Integer> st;
    public boolean isValidBST(TreeNode root) {
        st = new Stack<>();
        return inorder(root);
    }
    private boolean inorder(TreeNode root) {
        if(root == null) return true;
        boolean flag = inorder(root.left);
        if(!flag || (!st.isEmpty() && st.peek() >= root.val)) return false;
        st.push(root.val);
        //System.out.println(Arrays.toString(st.toArray()));
        return flag && inorder(root.right);
    }
}
