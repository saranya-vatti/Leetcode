/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val>l2.val ? 1 : (l1.val == l2.val ? 0 : -1);
            } 
        });
        for(int i=0;i<lists.length;i++) {
            if(lists[i] != null) pq.add(lists[i]);
        }
        ListNode tmp1 = pq.poll();
        if(tmp1 == null) return null;
        if(tmp1.next != null) {
            pq.add(tmp1.next);
        }
        ListNode head = new ListNode(tmp1.val);
        ListNode curr = head;
        while(!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            curr.next = new ListNode(tmp.val);
            curr=curr.next;
            if(tmp.next != null) {
                pq.add(tmp.next);
            }
        }
        return head;
    }
}