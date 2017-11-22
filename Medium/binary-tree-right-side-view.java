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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        list.add(root.val);
        while(!qu.isEmpty()) {
            /*System.out.println("Queue : " );
            for(TreeNode node:qu) {
                System.out.print(node.val + ", ");
            }
            System.out.println();*/
            Queue<TreeNode> tmpqu = new LinkedList(qu);
            qu = new LinkedList<>();
            int lastVal = -1; // ????
            while(!tmpqu.isEmpty()) {
                TreeNode parent = tmpqu.remove();
                if(parent.left != null) {
                    lastVal = parent.left.val;
                    qu.add(parent.left);
                }
                if(parent.right != null) {
                    lastVal = parent.right.val;
                    qu.add(parent.right);
                }
            }
            if(lastVal != -1) list.add(lastVal);
        }
        return list;
    }
}