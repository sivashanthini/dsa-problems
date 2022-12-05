package stack.hard;

import java.util.Stack;

/*
Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.

Problem Constraints
1 <= length of the each String <= 100

Input Format
The given arguments are string A and string B.

Output Format
Return 1 if they represent the same expression else return 0.

Example
Input 1:
 A = "-(a+b+c)"
 B = "-a-b-c"
Output 1:
1

Input 2:
 A = "a-b-(c-d)"
 B = "a-b-c-d"
Output 2:
0
 */
public class TwoBracketExpressionSame {
    private boolean checkSign(String str, int index) {
        if (index == 0)
            return true;
        if (str.charAt(index-1) == '-')
            return false;
        return true;
    }
    private void evaluate(String str, int[] vect, boolean expr) {
        Stack<Boolean> stack = new Stack();
        stack.push(true);
        int i = 0;
        while (i < str.length()) {
            //    System.out.println("char : " + str.charAt(i));
            if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                i++;
                continue;
            }
            if (str.charAt(i) == '(') {
                if (checkSign(str, i))
                    stack.push(stack.peek());
                else
                    stack.push(!stack.peek());
            } else if (str.charAt(i) == ')') {
                stack.pop();
            } else {
                //    System.out.println("vect : " + vect[str.charAt(i) - 'a']);
                if (stack.peek()) {
                    vect[str.charAt(i) - 'a'] += (checkSign(str, i) ?
                            expr ? 1 : -1 : expr ? -1 : 1);
                } else {
                    vect[str.charAt(i) - 'a'] += (checkSign(str, i) ?
                            expr ? -1 : 1 : expr ? 1 : -1);
                }
                //    System.out.println("vect after : " + vect[str.charAt(i) - 'a']);
            }
            i++;
        }
    }
    public int solve(String A, String B) {
        int[] vect = new int[26];
        evaluate(A, vect, true);
        evaluate(B, vect, false);
        for (int i = 0; i < 26; i++) {
            if (vect[i] != 0)
                return 0;
        }
        return 1;
    }
}
