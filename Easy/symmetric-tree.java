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
    private void inorder(TreeNode node, ArrayList<Integer> alist) {
        if(node == null) return;
        if(node.left == null && node.right != null) {
            alist.add(-1);
            alist.add(node.val);
            inorder(node.right, alist);
        } else if(node.right == null && node.left != null) {
            inorder(node.left, alist);
            alist.add(node.val);
            alist.add(-1);
        } else {
            inorder(node.left, alist);
            alist.add(node.val);
            inorder(node.right, alist);
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        TreeNode leftPointer = root.left;
        TreeNode rightPointer = root.right;
        Queue<TreeNode> leftqu = new LinkedList<>();
        Queue<TreeNode> rightqu = new LinkedList<>();
        leftqu.add(root.left);
        rightqu.add(root.right);
        while(!leftqu.isEmpty() && !rightqu.isEmpty()) {
            if(leftqu.size() != rightqu.size()) return false;
            /*System.out.println("Left : ");
            for(TreeNode node:leftqu) {
                System.out.print(node.val + ", ");
            }
            System.out.println();
            System.out.println("Right : ");
            for(TreeNode node:rightqu) {
                System.out.print(node.val + ", ");
            }
            System.out.println();*/
            TreeNode leftCurr = leftqu.remove();
            TreeNode rightCurr = rightqu.remove();
            if(leftCurr == null && rightCurr != null) return false;
            if(leftCurr != null && rightCurr == null) return false;
            if(leftCurr.val != rightCurr.val) return false;
            if(leftCurr.left == null && rightCurr.right != null) return false;
            if(leftCurr.left != null && rightCurr.right == null) return false;
            if(leftCurr.left != null) leftqu.add(leftCurr.left);
            if(leftCurr.right != null) leftqu.add(leftCurr.right);
            if(rightCurr.right != null) rightqu.add(rightCurr.right);
            if(rightCurr.left != null) rightqu.add(rightCurr.left);
        }
        return true;
    }
}