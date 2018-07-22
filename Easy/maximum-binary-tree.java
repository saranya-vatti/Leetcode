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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }
    private TreeNode construct(int[] arr, int start, int end) {
        if(start<0 || end>=arr.length) return null;
        if(start == end) return new TreeNode(arr[start]);
        if(start > end) return null;
        int max = arr[start], maxIndex = start;
        for(int i=start;i<=end;i++) {
            if(max<arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = construct(arr, start, maxIndex - 1);
        root.right = construct(arr, maxIndex + 1, end);
        return root;
    }
}
