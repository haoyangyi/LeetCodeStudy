package com.hyy.leetcode.linkedlist;

import com.hyy.leetcode.linkedlist.ListNode;

/**
 * 	206
 * 反转链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextTemp=curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}


