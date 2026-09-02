class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int len = 1;
        ListNode tail = head , temp = head;
        while(tail.next != null){
            len++;
            tail = tail.next;
        }

        if(k%len == 0) return head;
        k = (k%len);
        int nth = len-k-1;
        tail.next = head;
        while(nth > 0){
            nth--;
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;
        return head;
        
    }
}