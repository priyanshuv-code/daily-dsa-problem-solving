class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ans = new ListNode(0);
        ListNode curr = ans;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int carry = 0;

        while (temp1 != null && temp2 != null) {

            int sum = temp1.val + temp2.val + carry;

            if (sum < 10) {
                curr.next = new ListNode(sum);
                curr = curr.next;
            } else {
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
            }

            carry = sum / 10;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null) {

            int sum = temp1.val + carry;

            if (sum < 10) {
                curr.next = new ListNode(sum);
                curr = curr.next;
            } else {
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
            }

            carry = sum / 10;

            temp1 = temp1.next;
        }

        while (temp2 != null) {

            int sum = temp2.val + carry;

            if (sum < 10) {
                curr.next = new ListNode(sum);
                curr = curr.next;
            } else {
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
            }

            carry = sum / 10;

            temp2 = temp2.next;
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return ans.next;
    }
}