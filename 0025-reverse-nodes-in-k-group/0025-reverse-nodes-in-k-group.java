class Solution {
    public ListNode getKthNode(ListNode temp , int k){
        k -= 1;
        while(temp != null && k > 0){
            temp = temp.next;
            k--;
        }
        return temp;
    }
    public void reverseLinkedList(ListNode temp){
        if(temp == null || temp.next == null) return;

        ListNode prev = null , front = temp.next;
        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head , prevNode = null , nextNode = null;
        while(temp != null){
            ListNode kthNode = getKthNode(temp,k);
            if(kthNode == null){
                if(prevNode != null) prevNode.next = temp;
                break;
            }else {
                nextNode = kthNode.next;
                kthNode.next = null;
                reverseLinkedList(temp);
                if(temp == head) {
                    head = kthNode;
                }else prevNode.next = kthNode;
                prevNode = temp;
                temp = nextNode;

            }
        }
        return head;
    }
}