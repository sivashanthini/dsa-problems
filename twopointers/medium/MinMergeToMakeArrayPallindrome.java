/*
Given an array of positive integers. We need to make the given array a ‘Palindrome’.
The only allowed operation is”merging” (of two adjacent elements).
Merging two adjacent elements means replacing them with their sum.
The task is to find the minimum number of merge operations required to make the given array a ‘Palindrome’.

Input : arr[] = {15, 4, 15}
Output : 0
Array is already a palindrome. So we
do not need any merge operation.
Input : arr[] = {1, 4, 5, 1}
Output : 1
We can make given array palindrome with
minimum one merging (merging 4 and 5 to
make 9)
Input : arr[] = {11, 14, 15, 99}
Output : 3
We need to merge all elements to make
a palindrome.
 */
package twopointers.medium;

public class MinMergeToMakeArrayPallindrome {
    public static int findMinOps(int[] arr, int n) {
        int count = 0;
        for (int i = 0, j = n-1; i <= j;) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            }
            else if (arr[i] > arr[j]) {
                j--;
                arr[j] += arr[j+1];
                count++;
            } else {
                i++;
                arr[i] += arr[i-1];
                count++;
            }
        }
        return count;
    }
}
