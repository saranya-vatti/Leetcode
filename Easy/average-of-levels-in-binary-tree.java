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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avglist = new ArrayList<>();
        if(root == null) return avglist;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        avglist.add((double)root.val);
        while(!qu.isEmpty()) {
            /*System.out.println("Queue : " );
            for(TreeNode node:qu) {
                System.out.print(node.val + ", ");
            }
            System.out.println();*/
            Queue<TreeNode> tmpqu = new LinkedList(qu);
            qu = new LinkedList<>();
            double sum = 0;
            int count = 0;
            while(!tmpqu.isEmpty()) {
                TreeNode parent = tmpqu.remove();
                if(parent.left != null) {
                    sum += parent.left.val;
                    qu.add(parent.left);
                    count++;
                }
                if(parent.right != null) {
                    sum += parent.right.val;
                    qu.add(parent.right);
                    count++;
                }
            }
            if(count != 0) avglist.add(sum/count);
        }
        return avglist;
    }
}