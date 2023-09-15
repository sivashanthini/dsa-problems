/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

Solution:
Two pointers, left and right, are set at the head node. Move the right pointer n steps forward. After doing that, both pointers are exactly separated by n nodes apart. Start moving both pointers forward until the right pointer reaches the last node. At this point, the left pointer will be pointing to the node before the target node, i.e., the
nth last node. We relink the left node to the node next to left pointer’s next node.

If the right pointer reaches NULL while moving it n steps forward, it means that the head node should be removed. We return the head's next node.
 */
package linkedlist.medium;

import linkedlist.ListNode;

public class RemoveNNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode right = head, left = head;

        for(int i = 0; i < n; i++) right = right.next;
        if (right == null) return head.next;
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;

    }
}
