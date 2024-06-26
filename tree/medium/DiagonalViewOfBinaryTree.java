/*
Consider lines of slope -1 passing between nodes.

Given a Binary Tree A containing N nodes, return all diagonal elements in a binary tree belonging to same line.
Problem Constraints

 0 <= N <= 105


Input Format

First and only Argument represents the root of binary tree A.


Output Format

Return a 1D array denoting the diagonal traversal of the tree.


Example Input

Input 1:

            1
          /   \
         4      2
        / \      \
       8   5      3
          / \    /
         9   7  6

Input 2:

             11
          /     \
         20      12
        / \       \
       1   15      13
          /  \     /
         2    17  16
          \   /
          22 34



Example Output

Output 1:

 [1, 2, 3, 4, 5, 7, 6, 8, 9]

Output 2:

 [11, 12, 13, 20, 15, 17, 16, 1, 2, 22, 34]

 */
package tree.medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = A;
        while (node != null) {
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) node = node.right;
            else {
                if (!queue.isEmpty()) {
                    node = queue.peek();
                    queue.remove();
                } else
                    node = null;
            }
        }
        return list;
    }
}
