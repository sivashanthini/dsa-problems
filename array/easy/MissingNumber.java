/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
*/
//XOR with same number gives zero.

package array.easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = nums.length, i = 0;
        for (int num : nums) {
            result ^= i;
            result ^= num;
            i++;
        }
        return result;
    }
}

//Get sum of n natural numbers and subtract each key in the array
class MissingNumber2 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (len * (len + 1)) / 2;
        for (int num : nums) {
            sum = sum - num;
        }
        return sum;
        
    }
}
