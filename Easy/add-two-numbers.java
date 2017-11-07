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
        ListNode l3 = null;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode curr3 = l3;
        while(curr1 != null || curr2 != null || carry != 0) {
            int sum = carry;
            if(curr1 != null) sum += curr1.val;
            if(curr2 != null) sum += curr2.val;
            ListNode tmp = new ListNode(sum%10);
            if(l3 == null) {
                l3 = tmp;
                curr3 = l3;
            } else {
                curr3.next = tmp;
                curr3 = curr3.next;
            }
            if(curr1 != null) curr1 = curr1.next;
            if(curr2 != null) curr2 = curr2.next;
            carry = sum/10;
        }
        return l3;
    }
}