/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = null;
        ListNode currPointer = null;
        ListNode leftPointer = l1;
        ListNode rightPointer = l2;
        while(leftPointer != null && rightPointer != null) {
            if(leftPointer.val >= rightPointer.val) {
                if(currPointer == null) {
                    currPointer = new ListNode(rightPointer.val);
                    start = currPointer;
                } else {
                    currPointer.next = new ListNode(rightPointer.val);
                    currPointer = currPointer.next;
                }
                // System.out.println("Adding : " + rightPointer.val);
                rightPointer = rightPointer.next;
            } else {
                if(currPointer == null) {
                    currPointer = new ListNode(leftPointer.val);
                    start = currPointer;
                } else {
                    currPointer.next = new ListNode(leftPointer.val);
                    currPointer = currPointer.next;
                }
                // System.out.println("Adding : " + leftPointer.val);
                leftPointer = leftPointer.next;
            }
        }
        while(rightPointer != null) {
            if(currPointer == null) {
                currPointer = new ListNode(rightPointer.val);
                start = currPointer;
            } else {
                currPointer.next = new ListNode(rightPointer.val);
                currPointer = currPointer.next;
            }
            // System.out.println("Adding : " + rightPointer.val);
            rightPointer = rightPointer.next;
        }
        while(leftPointer != null) {
            if(currPointer == null) {
                currPointer = new ListNode(leftPointer.val);
                start = currPointer;
            } else {
                currPointer.next = new ListNode(leftPointer.val);
                currPointer = currPointer.next;
            }
            // System.out.println("Adding : " + leftPointer.val);
            leftPointer = leftPointer.next;
        }
        return start;
        
    }
}