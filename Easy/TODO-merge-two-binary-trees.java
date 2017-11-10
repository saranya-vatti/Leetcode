package com.company;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null) {
            TreeNode newTree = new TreeNode(t2.val);
            newTree.left = t2.left;
            newTree.right = t2.right;
            return newTree;
        } else if(t2==null) {
            TreeNode newTree = new TreeNode(t2.val);
            newTree.left = t2.left;
            newTree.right = t2.right;
            return newTree;
        } else {
            TreeNode newTree = new TreeNode(t1.val + t2.val);
            newTree.left = mergeTrees(t1.left, t2.left);
            newTree.right = mergeTrees(t1.right, t2.right);
            return newTree;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(mergeTrees(15));
    }
}
