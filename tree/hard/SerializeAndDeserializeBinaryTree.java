/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:
Input: root = []
Output: []

Constraints:
    The number of nodes in the tree is in the range [0, 104].
    -1000 <= Node.val <= 1000
 */
package tree.hard;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
          sb.append("#,");
          return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }
    public TreeNode deserialize(String data) {
        Queue<String> que = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserializeHelper(que);
    }

    private TreeNode deserializeHelper(Queue<String> que) {
        String str = que.poll();
        if (str.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = deserializeHelper(que);
        node.right = deserializeHelper(que);
        return node;
    }
}
