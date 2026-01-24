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
        ListNode tempa=headA;
        ListNode tempb=headB;
        int sizea=0;
        int sizeb=0;
        while(tempa!=null){
            sizea++;
            tempa=tempa.next;
        }
        while(tempb!=null){
            sizeb++;
            tempb=tempb.next;
        }
        tempa=headA;
        tempb=headB;
        int csa=sizea-sizeb;
        int csb=sizeb-sizea;
        if(csa>csb){
            for(int i=0;i<csa;i++){
                tempa=tempa.next;
            }
        }
        if(csb>csa){
            for(int i=0;i<csb;i++){
                tempb=tempb.next;
        }
    }
    while(tempa!=tempb){
        tempa=tempa.next;
        tempb=tempb.next;
    }
    return tempa;
    }
}