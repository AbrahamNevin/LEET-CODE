class Solution {
    public ListNode partition(ListNode head, int x) {
        // Dummy heads
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        // Pointers to build the two lists
        ListNode before = beforeHead;
        ListNode after = afterHead;

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

        // End the "after" list
        after.next = null;

        // Connect before and after
        before.next = afterHead.next;

        return beforeHead.next;
    }
}
