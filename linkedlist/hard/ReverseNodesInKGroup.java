/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]


Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000


Follow-up: Can you solve the problem in O(1) extra memory space?
 */
package linkedlist.hard;

import linkedlist.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode ptr = dummy;
        while (ptr != null) {
            ListNode tracker = ptr;
            for (int i = 0; i < k; i++) {
                if (tracker == null)
                    break;
                tracker = tracker.next;
            }
            if (tracker == null)
                break;
            ListNode currentNode = ptr.next, prevNode = null, nextNode = null;
            for (int i = 0; i < k; i++) {
                nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = nextNode;
            }
            ListNode lastNodeInRversedGroup = ptr.next;
            lastNodeInRversedGroup.next = currentNode;
            ptr.next = prevNode;
            ptr = lastNodeInRversedGroup;
        }
        return dummy.next;
    }
    public ListNode reverseKGroupUsingRecursion(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { //find the k+1 node
            count++;
            curr = curr.next;
        }
        if (count == k) {
            curr = reverseKGroupUsingRecursion(curr, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }
        return head;
    }
}
