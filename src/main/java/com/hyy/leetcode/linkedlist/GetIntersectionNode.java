package com.hyy.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 	160
 * 相交链表
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode head = headA;
        while(head!=null){
            nodeSet.add(head);
            head = head.next;
        }
        head = headB;
        while (head!=null){
            if(nodeSet.contains(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;
        while(head1!=head2){
            if(head1==null){
                head1 = headB;
            }else{
                head1=head1.next;
            }
            if(head2==null){
                head2 = headA;
            }else{
                head2=head2.next;
            }
        }
        return  head1;
    }
}
