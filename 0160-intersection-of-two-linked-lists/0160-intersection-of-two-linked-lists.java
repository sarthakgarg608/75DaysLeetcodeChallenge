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
    public ListNode collisonPoint(ListNode temp1 , ListNode temp2, int d){
        while(d != 0){
            d--;
            temp2 = temp2.next;
        }

        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int n1 = 0 , n2 = 0;
        while(temp1 != null){
            n1++;
            temp1 = temp1.next;
        }

        while(temp2 != null){
            n2++;
            temp2 = temp2.next;
        }

        // collisonPoint(smaller , greater , dist)

        if(n1 < n2) return collisonPoint(headA,headB,n2-n1);
        else return collisonPoint(headB,headA,n1-n2);
    }
}