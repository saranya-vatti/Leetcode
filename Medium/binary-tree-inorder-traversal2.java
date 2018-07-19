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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> st= new Stack<TreeNode>();
        TreeNode curr = root;
        while(true) {
            while(curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            if(curr == null && !st.isEmpty()) {
                curr = st.pop();
                list.add(curr.val);
                curr = curr.right;
            } else {
                break;
            }
        }
        return list;
    }
}
