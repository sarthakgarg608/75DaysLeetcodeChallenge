class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        if(k % len == 0) return head;
        k = (k % len);

        temp = head;
        for(int i = 1 ; i < len-k ; i++) temp = temp.next;

        ListNode nextNode = temp.next;
        temp.next = null;

        ListNode tail = nextNode;
        while(tail.next != null) tail = tail.next;
        tail.next = head;
        head = nextNode;
        return head;
    }
}