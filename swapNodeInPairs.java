/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Dummy node to simplify handling head swaps
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        // Traverse the list in pairs
        while (current.next != null && current.next.next != null) {
            // Identify the two nodes to be swapped
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swap them
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move current pointer to the next pair
            current = first;
        }

        return dummy.next;
    }
}
