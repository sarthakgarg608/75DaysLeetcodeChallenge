class Solution {
    public ListNode reverseLinkedList(ListNode temp){
        if(temp == null || temp.next == null){
            return temp;
        }
        ListNode prev = null , front = temp.next;
        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        // 1. step find the middle of the linked list in case of even find first middle 
        // 2. step reverse the second linked list 
        // 3. comparison both the first and second linked list 
        // final step reverseBack the second linked list

        ListNode slow = head , fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseLinkedList(slow.next);

        ListNode first = head , second = newHead;
        while(second != null){
            if(first.val != second.val){
                head = reverseLinkedList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        head = reverseLinkedList(newHead);
        return true;
    }
}