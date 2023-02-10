/*
Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
B[i][0] to node B[i][1].
Find whether a path exists from node 1 to node A.
Return 1 if path exists else return 0.

NOTE:

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
Return 1 if path exists between node 1 to node A else return 0.

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
 0

Output 2:
 1
 */

package graph.easy;

import java.util.ArrayList;

public class PathInDirectedGraph {
    public int solve(int A, int[][] B) {
        int ans = 0;
        boolean[] visited = new boolean[A+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < B.length; i++) {
            int src = B[i][0];
            int dest = B[i][1];
            adj.get(src).add(dest);
        }
        if ( dfs(visited, 1, A, adj))
            return 1;
        return 0;


    }
    private boolean dfs (boolean[] visited, int u, int v, ArrayList<ArrayList<Integer>> adj) {
        visited[u] = true;
        if (u == v)
            return true;
        ArrayList<Integer> edges = adj.get(u);
        for (Integer edge : edges) {
            if (!visited[edge] && dfs(visited, edge, v, adj))
                return true;
        }
        return false;

    }
}
