/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Constraints:
    1 <= nums.length <= 105
    -109 <= nums[i] <= 109

*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int number : nums) {
            if (numSet.contains(number)) {
                return true;
            } else {
                numSet.add(number);
            }
        }
        return false;
    }
}
