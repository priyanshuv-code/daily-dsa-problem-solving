/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)break;
        }
        if (fast == null || fast.next == null)return null;
        int cnt1=1;
        slow=slow.next;
        while(slow!=fast){
            slow=slow.next;
            cnt1++;
        }
        ListNode temp=head;
        for(int i=0;i<cnt1;i++){
            temp=temp.next;
        }
        slow=head;
        while(slow!=temp){
            slow=slow.next;
            temp=temp.next;
        }
        return slow;
    }
}