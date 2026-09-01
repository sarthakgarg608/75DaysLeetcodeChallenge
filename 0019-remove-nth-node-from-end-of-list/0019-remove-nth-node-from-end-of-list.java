class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head , fast = head;
        for(int step = 1 ; step <= n ; step++) fast = fast.next;

        if(fast == null) return head.next;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        ListNode newHead = head;
        return newHead;
    }
}