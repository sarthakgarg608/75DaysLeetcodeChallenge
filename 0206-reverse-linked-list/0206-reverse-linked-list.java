class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        Stack<Integer> st = new Stack<>();
        while(temp != null) {
            st.add(temp.val);
            temp = temp.next;
        } 

        temp = head;
        while(temp != null){
            temp.val = st.pop();
            temp = temp.next;
        }
        return head;       
    }
}