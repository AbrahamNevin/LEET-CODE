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
    public ListNode partition(ListNode head, int x) {
        // Dummy heads for two new linked lists
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        // Pointers for building the two lists
        ListNode before = beforeHead;
        ListNode after = afterHead;

        // Traverse the original list
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Important: terminate the "after" list
        after.next = null;

        // Connect the two lists
        before.next = afterHead.next;

        // Return the head of the rearranged list
        return beforeHead.next;
    }
}
