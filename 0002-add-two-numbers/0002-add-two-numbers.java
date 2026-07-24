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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1=l1;
        ListNode t2=l2;

        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int carry=0;
        while(t1!=null || t2!=null || carry != 0){
            int x=(t1!=null)?t1.val:0;
            int y=(t2!=null)?t2.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            int digit=sum%10;
            curr.next=new ListNode(digit);
            curr=curr.next;
            if(t1!=null) t1=t1.next;
            if(t2!=null) t2=t2.next;
        }
        return dummy.next;
    }
}