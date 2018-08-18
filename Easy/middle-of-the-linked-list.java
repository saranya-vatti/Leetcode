/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null) return head;
        ListNode curr = head;
        int len = 0;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        int mid = (len/2) + 1;
        curr = head;
        int index = 1;
        while(curr != null && index < mid) {
            index++;
            curr = curr.next;
        }
        return curr;
    }
}
