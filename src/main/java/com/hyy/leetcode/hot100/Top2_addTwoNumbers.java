package com.hyy.leetcode.hot100;

/**
 * @program: LeetCodeStudy
 * @description:
 * @author: hyy
 * @create: 2021-03-23 17:38
 *
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Top2_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode curr = prev;
        int carry = 0;
        while(l1!=null||l2!=null||carry!=0){
            int val1 = l1!=null?l1.val:0;
            int val2 = l2!=null?l2.val:0;
            int sumVal = val1+val2+carry;
            int val = sumVal%10;
            carry = sumVal/10;
            curr.next = new ListNode(val);
            curr = curr.next;
            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;
        }
        return prev.next;
    }
}
