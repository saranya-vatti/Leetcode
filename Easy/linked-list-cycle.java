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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return false;
        while(head!=null && head.next != null) {
            if(head.val == head.next.val) return true;
            head.next = head.next.next;
            head = head.next;
        }
        return false;
    }
}
