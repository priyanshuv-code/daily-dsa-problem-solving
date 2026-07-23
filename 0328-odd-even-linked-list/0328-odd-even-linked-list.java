/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        ListNode temp=head;
        while(temp!=null){
            curr.next=new ListNode(temp.val);
            curr=curr.next;
            if (temp.next != null){
                temp = temp.next.next;
            }   
            else{
                temp = null;
            }
        }
        temp=head.next;
        while(temp!=null){
            curr.next=new ListNode(temp.val);
            curr=curr.next;
            if (temp.next != null){
                temp = temp.next.next;
            }   
            else{
                temp = null;
            }
        }
        return dummy.next;
        
    }
}