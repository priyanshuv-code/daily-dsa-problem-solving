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
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null) return null;
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        k = k % size;
        temp=head;
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        for(int i=0;i<size-k;i++){
            temp=temp.next;
        }
        while(temp!=null){
            curr.next=new ListNode(temp.val);
            curr=curr.next;
            temp=temp.next;
        }
        temp=head;
        for(int i=0;i<size-k;i++){
            curr.next=new ListNode(temp.val);
            curr=curr.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}