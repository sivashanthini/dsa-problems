/*
Given an array (or string), the task is to reverse the array/string.
 */
package array.easy;

public class ArrayReverse {
    public void reverseArrayInPlace(int[] arr) {
        if (arr.length <= 1) return;
        int left = 0, right = arr.length-1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
