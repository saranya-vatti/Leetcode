/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// [3,1,5,0,2,4,6,null,null,null,3] : 3
// [0] : 0
class Solution {
    private int helper(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int leftmost = root.val;
        while(!qu.isEmpty()) {
            /*System.out.println("Queue : " );
            for(TreeNode node:qu) {
                System.out.print(node.val + ", ");
            }
            System.out.println();*/
            Queue<TreeNode> tmpqu = new LinkedList(qu);
            qu = new LinkedList<>();
            List<Integer> alist = new ArrayList<Integer>();
            while(!tmpqu.isEmpty()) {
                TreeNode parent = tmpqu.remove();
                if(parent.left != null) {
                    alist.add(parent.left.val);
                    qu.add(parent.left);
                }
                if(parent.right != null) {
                    alist.add(parent.right.val);
                    qu.add(parent.right);
                }
            }
            if(!alist.isEmpty()) leftmost = alist.get(0);
        }
        return leftmost;
    }
    public int findBottomLeftValue(TreeNode root) {
        return helper(root);
    }
}