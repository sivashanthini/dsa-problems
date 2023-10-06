/*
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 105

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the number of inversions of A modulo (109 + 7).



Example Input
Input 1:

A = [1, 3, 2]
Input 2:

A = [3, 4, 1, 2]


Example Output
Output 1:

1
Output 2:

4
 */
package sorting.medium;

public class InversionCount {
    public int solve(int[] A) {
        return mergeSort(A, 0, A.length-1);
    }

    private static int mergeSort(int[] A, int left, int right) {
        int count = 0;
        long mod = 1000000007;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(A, left, mid);
            count += mergeSort(A, mid+1, right);
            count += merge(A, left, mid, right);
        }
        return (int)(count % mod);
    }
    private static int merge(int[] A, int left, int mid, int right) {
        long mod = 1000000007;
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = A[left + i];
        for (int i = 0; i < n2; i++) R[i] = A[mid + 1 + i];
        int i = 0, j = 0, k = left, count = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                A[k++] = L[i++];
            else {
                A[k++] = R[j++];
                count += (mid + 1) - (left + i);
            }
        }
        while (i < n1) A[k++] = L[i++];
        while (j < n2) A[k++] = R[j++];
        return (int)(count % mod);
    }
}
