/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // let's say head1 has length n1 and head2 as n2 and the difference d if n1 traverse n1 + n2 and head2 traverse n2+n1 the distance travelled by both node same and at a certain point we will we having same point

        ListNode temp1 = headA , temp2 = headB;
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2) return temp1;

            if(temp1 == null) temp1 = headB;
            if(temp2 == null) temp2 = headA;
        }

        return temp1;
    }
}