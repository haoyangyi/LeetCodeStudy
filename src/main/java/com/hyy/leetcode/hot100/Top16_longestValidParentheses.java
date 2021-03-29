package com.hyy.leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class Top16_longestValidParentheses {

    /**
     * 栈
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxans = Math.max(maxans,i-stack.peek());
                }
            }
        }
        return maxans;
    }
    /**
     * 正向逆向结合法
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        int maxans = 0,left = 0,right = 0;

        for(int i =0;i< s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else {
                right++;
            }
            if(left<right){
                left = 0;
                right = 0;
            }
            if(left == right){
                maxans = Math.max(maxans,left+right);
            }
        }

        left =0;
        right = 0;
        for(int i =s.length()-1;i>=0;i--){
            if(s.charAt(i)=='('){
                left++;
            }else {
                right++;
            }
            if(left>right){
                left = 0;
                right = 0;
            }
            if(left == right){
                maxans = Math.max(maxans,left+right);
            }
        }
        return maxans;

    }
}
