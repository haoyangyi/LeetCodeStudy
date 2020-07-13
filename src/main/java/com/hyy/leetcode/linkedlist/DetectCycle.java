package com.hyy.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 	142
 * 环形链表 II
 */
public class DetectCycle {

    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();

        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }

        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(true){
            if(fast == null||fast.next == null){return null;}
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        fast = head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
