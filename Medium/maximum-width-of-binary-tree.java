/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// [1,2,3,null,null,4,5,6,7,8,9] 4
// [1,3,2,5] 2
// [1,3,2,5,3,null,9] 4
// [1,3,null,5,3] 2
// [1,3,2,5] 2
// [1,3,2,5,null,null,9] 4
// [1,2,3,null,null,4,5,6,7] 2
// [1,1,1,1,null,null,1,1,null,null,1] 8
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if(root==null) return maxWidth;
        Deque<TreeNode> qu= new LinkedList<TreeNode>();
        qu.add(root);
        int w = getWidth(qu);
        while(w>0) {
            if(maxWidth < w) maxWidth = w;
            Deque<TreeNode> childQueue = new LinkedList<TreeNode>();
            while(!qu.isEmpty()) {
                TreeNode curr = qu.removeFirst();
                if(curr != null) {
                    childQueue.add(curr.left);
                    childQueue.add(curr.right);
                } else {
                    childQueue.add(null);
                    childQueue.add(null);
                }
            }
            qu = childQueue;
            w = getWidth(qu);
            //System.out.println(w);
        }
        return maxWidth;
    }
    private int getWidth(Deque<TreeNode> childQueue) {
        while(childQueue.size() >0 && childQueue.peekFirst() == null) childQueue.removeFirst();
        while(childQueue.size() >0 && childQueue.peekLast() == null) childQueue.removeLast();
        return childQueue.size();
        
    }
}
