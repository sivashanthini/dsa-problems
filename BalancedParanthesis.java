/*
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Problem Constraints
  1 <= |A| <= 100

Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.

Output Format
Return 0 if the parenthesis sequence is not balanced.
Return 1 if the parenthesis sequence is balanced.
*/
public class Solution {
    public int solve(String A) {
        Stack<String> stack = new Stack<>();
        String[] stringArray = A.split("");
        for (String item : stringArray) {
            if (item.equals("{") || item.equals("(") || item.equals("["))
                stack.push(item);
            else if (stack.isEmpty() && (item.equals("}") || item.equals(")") || item.equals("]")))
                return 0;
            else if (item.equals("}") && !stack.isEmpty()) {
                String pop = stack.pop();
                if (!pop.equals("{"))
                    return 0;
            }
            else if (item.equals("]") && !stack.isEmpty()) {
                String pop = stack.pop();
                if (!pop.equals("["))
                    return 0;
            }
            else if (item.equals(")") && !stack.isEmpty()) {
                String pop = stack.pop();
                if (!pop.equals("("))
                    return 0;
            }
        }
        if (stack.isEmpty())
            return 1;
        return 0;
    }
}
