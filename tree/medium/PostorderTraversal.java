/*
Given a binary tree, return the Postorder traversal of its nodes values.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the Postorder traversal of the given binary tree.

Algorithm:

Step1:- Create an empty stack.
Step2:- Create a variable current that will initialize with root.
    current = root
Step 3:- Run a while loop until the stack becomes empty or the current points to null.
    Step 3.1:- Begin traversing the tree and pushing the nodes onto the stack by incrementing the current variable to the next left node until it hits null.
        current = current->left;
    Step 3.2:- When the current variable is null, create a previousNode variable of type Node that points to the right child of the node at the top of the stack.
        Node previousNode = stack.peek()->right
    Step 3.3:- If the previousNode is null, pop the peek value from the stack and assign it to the previousNode. Now, Print previousNode.
    Step 3.4:- Run a while loop until the stack becomes and the value in the previousNode matches the right node of the node present at the top of the stack.
        Step 3.4.1:- Pop the top value from the stack and assign the popped value to the previousNode.
        Step 3.4.2:- Print previousNode.
    Step 3.5:- If the previousNode isn’t null, assign its value to the current Node.
    Continue following the above steps until the stack becomes empty.
 */
package tree.medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = A;
        TreeNode prev = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                prev = stack.peek().right;
                if (prev == null) {
                    prev = stack.pop();
                    list.add(prev.val);
                    while (!stack.isEmpty() && prev == stack.peek().right) {
                        prev = stack.pop();
                        list.add(prev.val);
                    }
                } else curr = prev;
            }
        }
        return list;
    }
}
