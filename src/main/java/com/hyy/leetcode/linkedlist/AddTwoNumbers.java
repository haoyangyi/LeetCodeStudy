package com.hyy.leetcode.linkedlist;

/**
 * 	2
 * 两数相加
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode curr = prev;
        int carry = 0;
        while(l1!=null||l2!=null||carry!=0){
            int l1Val=l1!=null?l1.val:0;
            int l2Val=l2!=null?l2.val:0;
            int sumVal=l1Val+l2Val+carry;

            carry=sumVal/10;
            int currVal=sumVal%10;
            curr.next=new ListNode(currVal);
            curr=curr.next;

            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }
        return prev.next;
    }
}
