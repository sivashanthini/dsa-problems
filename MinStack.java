 Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

NOTE:
    All the operations have to be constant time operations.
    getMin() should return -1 if the stack is empty.
    pop() should return nothing if the stack is empty.
    top() should return -1 if the stack is empty.

Problem Constraints
1 <= Number of Function calls <= 107

Input Format
Functions will be called by the checker code automatically.

Output Format
Each function should return the values as defined by the problem statement. 

Input 1:
push(1)
push(2)
push(-2)
getMin()
pop()
getMin()
top()

Output 1:
 -2 1 2
 
Input 2:
getMin()
pop()
top()

Output 2:
 -1 -1
*/
class Solution {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution() {
        stack1 = new Stack();
        stack2 = new Stack();
    }
    public void push(int x) {   
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek())
            stack2.push(x);
    }

    public void pop() {
        if (stack1.isEmpty())
            return;
        int num = stack1.pop();
        if (num == stack2.peek())
            stack2.pop();
    }

    public int top() {
        if (stack1.isEmpty())
            return -1;
        return stack1.peek();
    }

    public int getMin() {
        if (stack2.isEmpty())
            return -1;
        return stack2.peek();
    }
}


