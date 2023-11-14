/*
Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [0]
Output: [0]

Constraints:
    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100

Follow up: Can you flatten the tree in-place (with O(1) extra space)?
Solution : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/solutions/1207642/js-python-java-c-simple-o-1-space-recursive-solutions-w-explanation/
https://www.youtube.com/watch?v=sWf7k1x9XR4
 */
package tree.medium;

import tree.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    //Morris traversal
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode last = current.left;
                while (last.right != null) last = last.right;
                last.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    TreeNode prev = null;
    public void flattenRecursion(TreeNode root) {
        if (root != null) helper(root);
    }

    private void helper(TreeNode node) {
        if (node.right != null) helper(node.right);
        if (node.left != null) helper(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }
}
