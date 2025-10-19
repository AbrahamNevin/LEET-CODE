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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Step 1: Create a dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 2: Move 'prev' to the node before 'left'
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: 'start' points to the beginning of the sublist to reverse
        ListNode start = prev.next;
        ListNode then = start.next;

        // Step 4: Reverse nodes between left and right
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        // Step 5: Return the new head
        return dummy.next;
    }
}
