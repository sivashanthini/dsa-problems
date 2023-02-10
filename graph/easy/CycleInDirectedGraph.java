/*
Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

    The cycle must contain atleast two nodes.
    There are no self-loops in the graph.
    There are no multiple edges between two nodes.
    The graph may or may not be connected.
    Nodes are numbered from 1 to A.
    Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Problem Constraints
2 <= A <= 105
1 <= M <= min(200000,A*(A-1))
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Output Format
Return 1 if cycle is present else return 0.

Example Input
Input 1:
 A = 5
 B = [  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]

Input 2:
 A = 5
 B = [  [1, 2]
        [2, 3]
        [3, 4]
        [4, 5] ]

Example Output
Output 1:
 1

Output 2:
 0
 */

package graph.easy;

import java.util.ArrayList;

public class CycleInDirectedGraph {
    public int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for (int i = 0; i <= A; i++)
            adj.add(new ArrayList());
        for (int i = 0; i < B.length; i++)
            adj.get(B[i][0]).add(B[i][1]);
        boolean[] visited = new boolean[A+1];
        boolean[] path = new boolean[A+1];
        for (int i = 1; i <= A; i++) {
            if (!visited[i] && dfs(visited, path, adj, i))
                return 1;
        }
        return 0;
    }

    private boolean dfs(boolean[] visited, boolean[] path, ArrayList<ArrayList<Integer>> adj, int node) {
        visited[node] = true;
        path[node] = true;
        for (Integer edge : adj.get(node)) {
            if (path[edge])
                return true;
            if (!visited[edge] && dfs(visited, path, adj, edge))
                return true;
        }
        path[node] = false;
        return false;

    }
}
