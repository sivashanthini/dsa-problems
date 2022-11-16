/*
You are given a matrix A of size N x 2 which represents different operations.
Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:
1 x: push an integer x onto the stack and return -1.
2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.

Problem Constraints
  1 <= N <= 100000
  1 <= A[i][0] <= 2
  0 <= A[i][1] <= 109
  
Input Format
The only argument given is the integer array A.

Output Format
Return the array of integers denoting the answer to each operation.

Input 1:
A =  [   
        [1, 5]
        [2, 0]
        [1, 4]   ]
Output 1:
 [-1, 5, -1]
*/
public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        HashMap<Integer,Integer> elementCountMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,HashSet<Integer>> freqCountMap = new HashMap<>();
        int max = 0;
        for (ArrayList list : A) {
            Integer operation = (Integer) list.get(0);
            Integer element = (Integer) list.get(1);
            if (operation.equals(1)) {
                result.add(-1);
                stack.push(element);
                if (elementCountMap.containsKey(element))
                    elementCountMap.put(element, elementCountMap.get(element)+1);
                else
                    elementCountMap.put(element, 1);
                int freq = elementCountMap.get(element);
                if (freqCountMap.containsKey(freq))
                    freqCountMap.get(freq).add(element);
                else {
                    freqCountMap.put(freq, new HashSet<Integer>(){{add(element);}});
                    max = max + 1;
                }
            } else {
                HashSet<Integer> tempSet = freqCountMap.get(max);
                while (true) {
                    int item = stack.pop();
                    if (tempSet.contains(item)) {
                        result.add(item);
                        tempSet.remove(item);
                        if (tempSet.isEmpty()) {
                            freqCountMap.remove(max);
                            max = max - 1;
                        }
                        int temp = elementCountMap.get(item)-1;
                        if (temp != 0) {
                            elementCountMap.put(item, temp);
                            freqCountMap.get(temp).add(item);
                        } else {
                            elementCountMap.remove(item);
                        }
                        break;
                    } else {
                        tempStack.push(item);
                    }
                }
                while (!tempStack.isEmpty()) {
                    stack.push(tempStack.pop());
                }
            }
        }
        return result;
    }
}
