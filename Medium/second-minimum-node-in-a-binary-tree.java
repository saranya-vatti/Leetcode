/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// [2,2,5,null,null,5,7] : 5
// [2,2,2,2,2,2,2,2,2] : -1
// [5,8,5] : 8
// [1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1] : 2
import java.math.*;
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        if(root.left == null) return -1;
        int leftSecMin = root.left.val;
        int rightSecMin = root.right.val;
        if(root.left.val == root.val) {
            leftSecMin = findSecondMinimumValue(root.left);
        }
        if(root.right.val == root.val) {
            rightSecMin = findSecondMinimumValue(root.right);
        }
        if(leftSecMin == -1 && rightSecMin == -1) return -1;
        if(leftSecMin == -1) return rightSecMin;
        if(rightSecMin == -1) return leftSecMin;
        return Math.min(leftSecMin, rightSecMin);
        
    }
}