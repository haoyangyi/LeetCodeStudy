package com.hyy.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: LeetCodeStudy
 * @description:
 * @author: hyy
 * @create: 2021-03-26 13:06
 *
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Top11_isValid {

    /**
     * 方法1 替换字符串
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        while(s.contains("()")||s.contains("{}")||s.contains("[]")){
            if(s.contains("()")) {
                s = s.replace("()", "");
            }
            if(s.contains("{}")) {
                s = s.replace("{}", "");
            }
            if(s.contains("[]")) {
                s = s.replace("[]","");
            }
        }
        return s.isEmpty();
    }

    public boolean isValid(String s) {
        if(s==null||s.length()%2==1){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack =new Stack<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(stack.isEmpty()||map.get(s.charAt(i))!=stack.peek()){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
