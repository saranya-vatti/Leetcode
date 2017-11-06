package com.company;
import java.math.BigInteger;
import java.util.*;
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
     }
}
public class Solution {
    public static void main(String[] args) {
        /*ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
        six.next = seven;
        seven.next = eight;
        eight.next = null;
        ListNode l1 = one;
        ListNode l2 = six;
        */
        ListNode five1 = new ListNode(5);
        ListNode five2 = new ListNode(5);
        ListNode l1 = five1;
        ListNode l2 = five2;

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
            carry = sum/10;
            if(l3 == null) {
                l3 = tmp;
                curr3 = l3;
            } else {
                curr3.next = tmp;
                curr3 = curr3.next;
            }
            if(curr1 != null) curr1 = curr1.next;
            if(curr2 != null) curr2 = curr2.next;
        }
        while (l3 != null) {
            System.out.print(l3.val + "->");
            l3 = l3.next;
        }
    }
}
