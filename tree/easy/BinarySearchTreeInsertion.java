package tree.easy;

import tree.TreeNode;

public class BinarySearchTreeInsertion {
    TreeNode root;
    public void insertIterative(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        TreeNode curr = root;
        while(curr != null) {
            if (curr.val <= value) {
                if (curr.left == null) {
                    curr.left = new TreeNode(value);
                    return;
                }
                curr = curr.left;
            }
            else if (curr.val > value) {
                if (curr.right == null) {
                    curr.right = new TreeNode(value);
                    return;
                }
                curr = curr.right;
            }
        }
    }
    private TreeNode insertRecursiveHelper(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (root.left.val <= value)
            root.left = insertRecursiveHelper(root.left, value);
        else
            root.right = insertRecursiveHelper(root.right, value);
        return root;
    }
    public void insertRecursive(int value) {
        this.root = insertRecursiveHelper(this.root, value);
    }
}
