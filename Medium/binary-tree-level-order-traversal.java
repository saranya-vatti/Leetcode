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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        List<Integer> rootList = new ArrayList<Integer>();
        rootList.add(root.val);
        lists.add(rootList);
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
            if(!alist.isEmpty()) lists.add(alist);
        }
        return lists;
    }
}