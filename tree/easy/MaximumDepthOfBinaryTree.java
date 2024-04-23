/*
Given the root of a binary tree, return its maximum depth (height of tree)
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Constraints:
    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
 */
package tree.easy;

import tree.TreeNode;

import java.util.ArrayDeque;

public class MaximumDepthOfBinaryTree {
    public int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepthRecursive(root.left);
        int right = maxDepthRecursive(root.right);
        return Math.max(left, right) + 1;
    }
    public int maxDepthIterative(TreeNode root)
    {
        int height = 0;
        if (root == null) return height;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            height++;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return height;
    }
}
