/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode ans = second;
        ListNode prev = null;
        while(first != null && second != null && second.next!=null) {
            ListNode tmp = second.next;
            second.next = first;
            if(prev == null) ans = second;
            else {
                prev.next = second;
            }
            prev = first;
            first.next = tmp;
            first = tmp;
            second = tmp.next;
        }
        if(prev!=null) prev.next = second;
        if(second!=null) second.next = first;
        else {
            prev.next = first;
        }
        first.next = null;
        return ans;
    }
}
