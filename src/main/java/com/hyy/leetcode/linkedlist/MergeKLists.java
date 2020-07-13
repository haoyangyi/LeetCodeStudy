package com.hyy.leetcode.linkedlist;

/**
 * 23
 * 合并K个排序链表
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = null;
        for(int i=0;i<lists.length;i++){
            node = mergeTwoLists(node,lists[i]);
        }
        return node;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }

}
