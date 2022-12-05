package stack.medium;/*
Given a stack of integers A, sort it using another stack.
Return the array of integers after sorting the stack using another stack.

Problem Constraints
  1 <= |A| <= 5000
  0 <= A[i] <= 109

Input Format
The only argument is a stack given as an integer array A.

Output Format
Return the array of integers after sorting the stack using another stack.

Input 1:
 A = [5, 4, 3, 2, 1]
Output 1:
 [1, 2, 3, 4, 5]
 
Input 2:
 A = [5, 17, 100, 11]
Output 2:
 [5, 11, 17, 100]
*/

import java.util.ArrayList;
import java.util.Stack;

public class SortStackUsingAnotherStack {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        ArrayList<Integer> result = new ArrayList();
        Integer topNum = null;
        for (Integer num : A) {
            if (stack1.isEmpty()) {
                stack1.push(num);
                continue;
            } 
            
            while (true) {
                if (!stack1.isEmpty()) 
                    topNum = stack1.peek();
                if (stack1.isEmpty() || num <= topNum) {
                    stack1.push(num);
                    break;
                } else {
                    stack2.push(stack1.pop());
                }
            }
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            } 
        }
        while (!stack1.isEmpty()) {
            result.add(stack1.pop());
        }
        return result;
    }
}
