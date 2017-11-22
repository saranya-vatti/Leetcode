// Implemented ListNode
import java.io.*;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
public class Main {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        if(headA.val == headB.val) return headA;
        int lenA = 0;
        ListNode currA = headA;
        while(currA != null) {
            lenA++;
            currA = currA.next;
        }
        ListNode currB = headB;
        int lenB = 0;
        while(currB != null) {
            lenB++;
            currB = currB.next;
        }
        ListNode smallerHead;
        ListNode other;
        int minPoss = -1;
        if(lenA <= lenB) {
            smallerHead = headA;
            other = headB;
            minPoss = lenB - lenA;
        } else {
            smallerHead = headB;
            other = headA;
            minPoss = lenA - lenB;
        }
        int tmp = 0;
        while(tmp != minPoss) {
            other = other.next;
            tmp++;
        }
        while(other != null) {
            if(other.val == smallerHead.val) return other;
            other = other.next;
            smallerHead = smallerHead.next;
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        /*ListNode headA = new ListNode(1);
        ListNode curr = headA;
        for(int i=2;i<=10;i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        ListNode headB = new ListNode(11);
        curr = headB;
        for(int i=12;i<=15;i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        for(int i=5;i<=10;i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }*/

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(51);
        ListNode headB = new ListNode(2);
        ListNode curr = headB;
        int[] arrB = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,
                46,48,50,51};
        for(int i=0;i<arrB.length;i++) {
            curr.next = new ListNode(arrB[i]);
            curr = curr.next;
        }
        /*while(headA != null) {
            System.out.print(headA.val + "->");
            headA = headA.next;
        }
        System.out.println();
        while(headB != null) {
            System.out.print(headB.val + "->");
            headB = headB.next;
        }*/
        System.out.println(getIntersectionNode(headA, headB).val);
    }
}
