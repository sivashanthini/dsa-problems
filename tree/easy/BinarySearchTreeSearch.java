package tree.easy;

import tree.TreeNode;

public class BinarySearchTreeSearch {
    public boolean searchIterative(TreeNode root, int value) {
        if (root == null) return false;
        TreeNode curr = root;
        while(curr != null) {
            if (curr.val == value) return true;
            if (curr.val < value) curr = curr.left;
            else curr = curr.right;
        }
        return false;
    }
    public boolean searchRecursive(TreeNode root, int value) {
        if (root == null) return false;
        if (root.val == value) return true;
        else if (root.val < value) searchRecursive(root.left, value);
        else searchRecursive(root.right, value);
        return false;
    }
}
