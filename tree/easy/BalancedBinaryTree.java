/*
Given a binary tree, determine if it is
height-balanced

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true

Constraints:
    The number of nodes in the tree is in the range [0, 5000].
    -104 <= Node.val <= 104
 */
package tree.easy;

import tree.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return heightOfTree(root) == -1 ? false : true;
    }
    private int heightOfTree(TreeNode node) {
        if (node == null) return 0;
        int left = heightOfTree(node.left);
        int right = heightOfTree(node.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
