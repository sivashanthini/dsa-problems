/*
Given a Binary Tree, perform the boundary traversal of the tree.
Example 1:
Input:Binary Tree: 1 2 7 3 -1 -1 8 -1 4 9 -1 5 6 10 11
Output: Boundary Traversal: [1, 2, 3, 4, 5, 6, 10, 11, 9, 8, 7]

Example 2:
Input:Binary Tree: 10 5 20 3 8 18 25 -1 7 -1 -1
Output : Boundary Traversal: [10, 5, 3, 7, 8, 18, 25, 20]

Solution Approach :
Left Boundary: Traverse the left boundary of the tree. Start from the root and keep moving to the left child; if unavailable, move to the right child. Continue this until we reach a leaf node.

Bottom Boundary: Traverse the bottom boundary of the tree by traversing the leaf nodes using a simple preorder traversal. We check if the current node is a lead, and if so, its value is added to the boundary traversal array.

Right Boundary: The right boundary is traversed in the reverse direction, similar to the left boundary traversal starting from the root node and keep moving to the right child; if unavailable, move to the left child.
Nodes that are not leaves are pushed into the right boundary array from end to start to ensure that they are added in the reverse direction.
 */
package tree.medium;

import tree.TreeNode;

import java.util.ArrayList;

public class BoundaryTraversalOfBinaryTree {
    public ArrayList<Integer> findBoundaryNodes(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        if (!isLeafNode(root)) list.add(root.val);
        leftBoundary(root, list);
        leaves(root, list);
        rightBoundary(root, list);
        return list;
    }
    private static void leftBoundary(TreeNode node, ArrayList<Integer> list) {
        TreeNode curr = node.left;
        while (curr != null) {
            if (!isLeafNode(curr)) list.add(curr.val);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    private static void leaves(TreeNode node, ArrayList<Integer> list) {
        if (isLeafNode(node)) {
            list.add(node.val);
            return;
        }
        if (node.left != null) leaves(node.left, list);
        if (node.right != null) leaves(node.right, list);
    }
    private static void rightBoundary(TreeNode node, ArrayList<Integer> list) {
        TreeNode curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeafNode(curr)) temp.add(curr.val);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for (int i = temp.size()-1; i >= 0; i--) list.add(temp.get(i));
    }
    private static boolean isLeafNode(TreeNode node) {
        return node.right == null && node.left == null;
    }

}
