/*
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.

You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE:
    In the array, the NULL/None child is denoted by -1.
    For more clarification check the Example Input.

Problem Constraints
1 <= number of nodes <= 105
-1 <= A[i] <= 105

Input Format
Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.

Output Format
Return the root node of the Binary Tree.

Example Input
Input 1:
 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]

Input 2:
 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]

Example Output
Output 1:
           1
         /   \
        2     3
       / \
      4   5

Output 2:
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6

*/

package tree.medium;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class DeserializeBinaryTree {
    public TreeNode solve(ArrayList<Integer> A) {
        TreeNode root = null;
        int level = 1;
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        if (A.size() == 0)
            return null;
        if (A.size() >= 1)
            root = new TreeNode(A.get(0));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.removeFirst();
            int left = A.get(i);
            int right = A.get(i+1);
            if (left != -1) {
                TreeNode leftNode = new TreeNode(left);
                queue.add(leftNode);
                temp.left = leftNode;
            }
            if (right != -1) {
                TreeNode rightNode = new TreeNode(right);
                queue.add(rightNode);
                temp.right = rightNode;
            }
            i = i + 2;
        }
        return root;
    }
}
