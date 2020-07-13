package com.hyy.leetcode.linkedlist;

/**
 * 	21
 * 合并两个有序链表
 */
public class MergeTwoLists {

    /**
     * 递归解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next,l1);
            return  l2;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode(-1);
        ListNode pre = preNode;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1==null?l2:l1;
        return preNode.next;
    }

    public static void main(String[] args) {
        ListNode node=new MergeTwoLists().mergeTwoLists1(new ListNode(1),new ListNode(2));
        System.out.println(node.val);
    }

}

