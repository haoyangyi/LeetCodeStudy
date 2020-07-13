package com.hyy.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 234
 * 回文链表
 */
public class IsPalindrome {


    /**
     * 复制链表值到数组列表中。
     * 使用双指针法判断是否为回文。
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        List<Integer> nodeList = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            nodeList.add(curr.val);
            curr=curr.next;
        }
        int left=0,right=nodeList.size()-1;
        while(left<right){
            if(!nodeList.get(left).equals(nodeList.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
