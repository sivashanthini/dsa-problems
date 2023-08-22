/*
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 */
package array.medium;

import java.util.HashMap;

public class RemoveDuplicateSortedArrayTwo {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
    public int removeDuplicatesApproachOne(int[] nums) {

        int j = 1, count = 1, num = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                if (count < 2)
                    nums[j++] = nums[i];
                count++;
            } else {
                count = 1;
                num = nums[i];
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public int removeDuplicatesApproachTwo(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int j = 1;
         map.put(nums[0], 1);
         for(int i = 1; i < nums.length; i++) {
             if(map.containsKey(nums[i])) {
                 if (map.get(nums[i]) < 2) {
                     nums[j++] = nums[i];
                 }
                 map.put(nums[i], map.get(nums[i]) + 1);
             } else {
                 map.put(nums[i], 1);
                 nums[j++] = nums[i];
             }
         }
        return j;
    }
}
