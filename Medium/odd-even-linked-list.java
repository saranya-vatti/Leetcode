/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode oddPointer = head;
        ListNode evenPointer = head.next;
        ListNode firstEvenPointer = evenPointer;
        while(evenPointer != null && evenPointer.next != null) {
            oddPointer.next = oddPointer.next.next;
            oddPointer = oddPointer.next;
            evenPointer.next = oddPointer.next;
            evenPointer = evenPointer.next;
        }
        oddPointer.next = firstEvenPointer;
        return head;
    }
}
