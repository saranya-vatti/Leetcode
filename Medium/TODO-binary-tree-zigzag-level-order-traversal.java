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
class Solution {
    private void helper(TreeNode node, List<List<Integer>> lists, int level, HashSet<TreeNode> visited) {
        if(node == null) return;
        visited.add(node);
        List<Integer> currList = new ArrayList<>();
        if(level < lists.size()) {
            currList = lists.get(level);
        }
        if(level%2 == 0) {
            if(node.left != null) {
                currList.add(node.left.val);
                helper(node.left, lists, level + 1, visited);
            }
            if(node.right != null) {
                currList.add(node.right.val);
                helper(node.right, lists, level + 1, visited);
            }
        } else {
            if(node.right != null) {
                currList.add(node.right.val);
                helper(node.right, lists, level + 1, visited);
            }
            if(node.left != null) {
                currList.add(node.left.val);
                helper(node.left, lists, level + 1, visited);
            }
        }
        if(!currList.isEmpty()) {
            int counter = lists.size();
            while(counter<level) {
                lists.add(new ArrayList<>());
                counter++;
            }
            System.out.println("Inserting into level : " + level);
            // lists.remove(level);
            lists.add(level, currList);
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 0 - left to right
        // 1 - right to left
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        List<Integer> currList = new ArrayList<>();
        currList.add(root.val);
        lists.add(currList);
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(root);
        helper(root, lists, 1, visited);
        return lists;
    }
}