/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.



Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]


Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n


Follow up: Could you do it in one pass?
 */
package linkedlist.medium;

import linkedlist.ListNode;

public class ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;
        ListNode current = head, prevPointer = null, nextPointer = null, first = new ListNode(-600, head), last = null, start = null, end = null;
        int count = 1 ;
        while (current != null) {
            if (count == left) {
                start = current;
                break;
            }
            first = current;
            current = current.next;
            count++;
        }
        while (current != null && count <= right) {
            if (count == right) {
                last = current.next;
                end = current;
            }
            nextPointer = current.next;
            current.next = prevPointer;
            prevPointer = current;
            current = nextPointer;
            count++;
        }
        start.next = last;
        first.next = end;
        if (left == 1)
            return first.next;
        return head;
    }
}
