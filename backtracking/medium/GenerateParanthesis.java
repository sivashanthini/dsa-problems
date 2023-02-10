/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.


Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

Constraints:
    1 <= n <= 8
*/

package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> list = new ArrayList();
    public List<String> generateParenthesis(int n) {
        printFirst(0, 0, "", n);
        return list;
    }
    private void printFirst(int open, int close, String str, int n) {
        if (str.length() == n*2) {
            list.add(str);
            return;
        }
        if (open < n) 
            printFirst(open+1, close, str+"(", n);
        if (close < open) 
            printFirst(open, close+1, str+")", n);
    }
}
