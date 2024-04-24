/*
Construct a binary tree from a string consisting of parenthesis and integers.
The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis.
The integer represents the root’s value and a pair of parenthesis contains a child binary tree with the same structure.
Always start to construct the left child node of the parent first if it exists.

Input : "1(2)(3)"
Output : 1 2 3
Explanation :
           1
          / \
         2   3
Explanation: first pair of parenthesis contains
left subtree and second one contains the right
subtree. Preorder of above tree is "1 2 3".

Input : "4(2(3)(1))(6(5))"
Output : 4 2 3 1 6 5
Explanation :
           4
         /   \
        2     6
       / \   /
      3   1 5
 */
package tree.medium;

import tree.TreeNode;

public class BinaryTreeFromBracketString {
    static int start = 0;
    public static TreeNode constructTree(String str) {
        return constructTreeHelper(str);
    }
    private static TreeNode constructTreeHelper(String str) {
        if (str == null || str.length() == 0) return null;
        if (start >= str.length()) return null;
        boolean neg = false;
        if (str.charAt(start) == '-') {
            neg = true;
            start++;
        }
        int num = 0;
        while (start < str.length() && Character.isDigit(str.charAt(start))) {
            num = num * 10  + Character.getNumericValue(str.charAt(start));
            start++;
        }
        if (neg) num = -num;
        TreeNode node = new TreeNode(num);
        if (start >= str.length()) return node;
        if (start < str.length() && str.charAt(start) == '(') {
            start++;
            node.left = constructTreeHelper(str);
        }
        if (start < str.length() && str.charAt(start) == ')') {
            start++;
            return node;
        }
        if (start < str.length() && str.charAt(start) == '(') {
            start++;
            node.right = constructTreeHelper(str);
        }
        if (start < str.length() && str.charAt(start) == ')') {
            start++;
            return node;
        }
        return node;
    }
    public static void main(String[] args)
    {
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = constructTree(s);
        printTree(root);
    }
    public static void printTree(TreeNode node)
    {
        if (node == null)
            return;

        System.out.println(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
