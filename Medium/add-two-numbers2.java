/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = null;
        ListNode head = null;
        while(l1!=null || l2 != null) {
            int sum = carry;
            if(l1!=null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if(head == null) {
                head = new ListNode(sum%10);
                ans = head;
            } else {
                ans.next = new ListNode(sum%10);
                ans = ans.next;
            }
            carry = sum/10;
        }
        if(carry>0) {
            ans.next = new ListNode(carry);
        }
        return head;
    }
}
