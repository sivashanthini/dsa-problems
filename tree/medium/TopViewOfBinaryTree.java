/*
Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.

The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.

Return the nodes in any order.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return an array, representing the top view of the binary tree.

Example Input

Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8

Input 2:
            1
           /  \
          2    3
           \
            4
             \
              5
Example Output

Output 1:
 [1, 2, 4, 8, 3, 7]

Output 2:
 [1, 2, 3]

 */
package tree.medium;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class TopViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A == null) return list;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        ArrayDeque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(A, 0));
        while (!deque.isEmpty()) {
            Pair pair = deque.removeFirst();
            int dist = pair.getDist();
            TreeNode node = pair.getNode();
            map.putIfAbsent(dist, new ArrayList<Integer>());
            map.get(dist).add(node.val);
            min = Math.min(dist, min);
            max = Math.max(dist, max);
            if (node.left != null) deque.add(new Pair(node.left, dist-1));
            if (node.right != null) deque.add(new Pair(node.right, dist+1));
        }
        for (int i = min; i <= max; i++) {
            list.add(map.get(i).get(0));
        }
        return list;
    }
    class Pair {
        int dist;
        TreeNode node;
        Pair(TreeNode node, int dist) {
            this.dist = dist;
            this.node = node;
        }
        int getDist() {
            return this.dist;
        }
        TreeNode getNode() {
            return this.node;
        }
    }
}
