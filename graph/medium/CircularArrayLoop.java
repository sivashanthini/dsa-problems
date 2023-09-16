/*
You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:

If nums[i] is positive, move nums[i] steps forward, and
If nums[i] is negative, move nums[i] steps backward.
Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.

A cycle in the array consists of a sequence of indices seq of length k where:

Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
Every nums[seq[j]] is either all positive or all negative.
k > 1
Return true if there is a cycle in nums, or false otherwise.



Example 1:


Input: nums = [2,-1,1,2,2]
Output: true
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
We can see the cycle 0 --> 2 --> 3 --> 0 --> ..., and all of its nodes are white (jumping in the same direction).
Example 2:


Input: nums = [-1,-2,-3,-4,-5,6]
Output: false
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
The only cycle is of size 1, so we return false.
Example 3:


Input: nums = [1,-1,5,1,4]
Output: true
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
We can see the cycle 0 --> 1 --> 0 --> ..., and while it is of size > 1, it has a node jumping forward and a node jumping backward, so it is not a cycle.
We can see the cycle 3 --> 4 --> 3 --> ..., and all of its nodes are white (jumping in the same direction).


Constraints:

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
nums[i] != 0


Follow up: Could you solve it in O(n) time complexity and O(1) extra space complexity?
 */
package graph.medium;

import java.util.Arrays;

public class CircularArrayLoop {
    public boolean circularArrayLoopUsingSlowAndFastPointer(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int slow = i, fast = i;
            boolean isForward = nums[i] > 0;
            while (true) {
                slow = nextStep(slow, nums[slow], size);
                if (isNotCycle(isForward, nums, slow)) break;
                fast = nextStep(fast, nums[fast], size);
                if (isNotCycle(isForward, nums, fast)) break;
                fast = nextStep(fast, nums[fast], size);
                if (isNotCycle(isForward, nums, fast)) break;
                if (slow == fast) return true;
            }
        }
        return false;
    }
    private static int nextStep(int pointer, int pointerValue, int size) {
        int nextPointer = (pointer + pointerValue) % size;
        if (nextPointer < 0)
            nextPointer += size;
        return nextPointer;
    }
    private static boolean isNotCycle(boolean currentDirection, int[] nums, int pointer) {
        boolean nextDirection = nums[pointer] > 0;
        if (currentDirection != nextDirection || Math.abs(nums[pointer] % nums.length) == 0)
            return true;
        return false;
    }

    public boolean circularArrayLoopUsingDFS(int[] nums) {
        int size = nums.length;
        if (size <= 1) return false;
        boolean visited[] = new boolean[size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(visited, false);
            if (dfs(nums, i, visited)) return true;
        }
        return false;
    }
    private static boolean dfs(int[] nums, int current, boolean[] visited) {
        if (visited[current]) return true; //its a loop
        int next = nextStep(current, nums[current], nums.length); //calculate the next step
        if (current == next) return false; //the next node node is same as current node eg 5,1,1,1,1 for 5 next node is 5 itself
        if ((nums[current] ^ nums[next]) < 0) return false; //the current direction is opposite to next node direction
        visited[current] = true;
        return dfs(nums, next, visited);
    }

}
