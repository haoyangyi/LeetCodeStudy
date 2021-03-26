package com.hyy.leetcode.hot100;

/**
 * @program: LeetCodeStudy
 * @description:
 * @author: hyy
 * @create: 2021-03-26 11:08
 *
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Top10_removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;
        ListNode right = dummy;
        for(int i=0;i<n+1;i++){
            right = right.next;
        }
        while (right!=null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
