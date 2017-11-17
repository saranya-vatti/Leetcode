/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    ArrayList<Integer> inorder = new ArrayList<Integer>();
    private int currentIndex = 0;
    
    private void createList(TreeNode node) {
        if(node == null) return;
        createList(node.left);
        inorder.add(node.val);
        createList(node.right);
    }

    public BSTIterator(TreeNode root) {
        createList(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return currentIndex < inorder.size();
    }

    /** @return the next smallest number */
    public int next() {
        currentIndex++;
        return inorder.get(currentIndex - 1);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */