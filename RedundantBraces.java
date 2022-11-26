/*
Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.

Check whether A has redundant braces or not.

NOTE: A will be always a valid expression and will not contain any white spaces.

Problem Constraints

1 <= |A| <= 105

Input Format

The only argument given is string A.

Output Format

Return 1 if A has redundant braces else, return 0.

Example Input

Input 1:

 A = "((a+b))"

Input 2:

 A = "(a+(a+b))"

Example Output

Output 1:

 1

Output 2:

 0
*/
public class Solution {
    public int braces(String A) {
        String[] splitString = A.split("");
        boolean isOperatorFound;
        HashSet<String> operators = new HashSet<String>(){{
            add("+");
            add("-");
            add("*");
            add("/");
        }};
        Stack<String> stack = new Stack<>();
        for  (String item : splitString) {
            if (item.equals(")")) {
                isOperatorFound = false;
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    if (operators.contains(stack.peek()))
                        isOperatorFound = true;
                    stack.pop();
                } 
                if (!isOperatorFound)
                    return 1;
                if (!stack.isEmpty() && stack.peek().equals("("))
                    stack.pop();
                else
                    return 1;
            }
            else
                stack.push(item);
        }
        return 0;
    }
}
