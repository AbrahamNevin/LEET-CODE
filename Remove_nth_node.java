class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases smoothly
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;

        // Move 'first' ahead by n+1 steps to keep a gap of n between first and second
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until 'first' reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Now 'second.next' is the node to be removed
        second.next = second.next.next;

        // Return the updated list
        return dummy.next;
    }
}
