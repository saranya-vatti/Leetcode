/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    private TreeNode root;
    private boolean nextLeft;
    private int activeIndex;
    private ArrayList<TreeNode> tree;

    public CBTInserter(TreeNode r) {
        this.root = r;
        this.nextLeft = true;
        this.activeIndex = -1;
        levelOrder(r);
        // printTree();
        // System.out.println("activeIndex = " + this.activeIndex);
    }
    
    private void printTree() {
        for(int i=0;i<tree.size();i++) {
            System.out.print(tree.get(i).val);
            System.out.print(",");
        }
        System.out.println();
    }
    
    private void levelOrder(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> qu= new LinkedList<TreeNode>();
        qu.add(root);
        while(!qu.isEmpty()) {
            Queue<TreeNode> childQueue = new LinkedList<TreeNode>();
            while(!qu.isEmpty()) {
                TreeNode curr = qu.remove();
                list.add(curr);
                if(curr.left != null) {
                    childQueue.add(curr.left);
                } else if(this.activeIndex == -1) {
                    this.activeIndex = list.size()-1;
                    nextLeft = true;
                }
                if(curr.right != null) {
                    childQueue.add(curr.right);
                } else if(this.activeIndex == -1) {
                    this.activeIndex = list.size()-1;
                    nextLeft = false;
                }
            }
            qu = childQueue;
        }
        this.tree = list;
    }
    
    public int insert(int v) {
        TreeNode activeNode = tree.get(activeIndex);
        TreeNode newNode = new TreeNode(v);
        if(nextLeft) {
            activeNode.left = newNode;
            nextLeft = false;
        } else {
            activeNode.right = newNode;
            activeIndex++;
            nextLeft = true;
        }
        tree.add(newNode);
        return activeNode.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
