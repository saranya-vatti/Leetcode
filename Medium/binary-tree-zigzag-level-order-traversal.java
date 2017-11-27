/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// [3,9,20,null,null,15,7] - [[3],[20,9],[15,7]]
// [1,2,3,4,null,null,5] - [[1],[3,2],[4,5]]
// [1,2,null,3,null,4,null,5] - [[1],[2],[3],[4],[5]]
// [0,2,4,1,null,3,-1,5,1,null,6,null,8] - [[0],[4,2],[1,3,-1],[8,6,1,5]]
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 0 - left to right
        // 1 - right to left
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        List<Integer> rootList = new ArrayList<Integer>();
        rootList.add(root.val);
        lists.add(rootList);
        int level = 1;
        while(!st.isEmpty()) {
            /*System.out.println("Stack : " );
            for(TreeNode node:st) {
                System.out.print(node.val + ", ");
            }
            System.out.println();*/
            Stack<TreeNode> tmpst = (Stack<TreeNode>)st.clone();
            st = new Stack<>();
            List<Integer> alist = new ArrayList<Integer>();
            while(!tmpst.isEmpty()) {
                TreeNode parent;
                parent = tmpst.pop();
                if(level%2 == 0) {
                    if(parent.left != null) {
                        alist.add(parent.left.val);
                        st.push(parent.left);
                    }
                    if(parent.right != null) {
                        alist.add(parent.right.val);
                        st.push(parent.right);
                    }
                } else {
                    if(parent.right != null) {
                        alist.add(parent.right.val);
                        st.push(parent.right);
                    }
                    if(parent.left != null) {
                        alist.add(parent.left.val);
                        st.push(parent.left);
                    }
                }
            }
            level++;
            if(!alist.isEmpty()) lists.add(alist);
        }
        return lists;
    }
}