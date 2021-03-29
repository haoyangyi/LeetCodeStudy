package com.hyy.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeStudy
 * @description:
 * @author: hyy
 * @create: 2021-03-26 16:11
 *
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Top13_generateParenthesis {

//    public List<String> generateParenthesis1(int n) {
//        List<String> combinations = new ArrayList<String>();
//        generateAll(new char[2 * n], 0, combinations);
//        return combinations;
//    }
//
//    public void generateAll(char[] current, int pos, List<String> result) {
//        if (pos == current.length) {
////            if (valid(current)) {
//                result.add(new String(current));
////            }
//        } else {
//            current[pos] = '(';
//            generateAll(current, pos + 1, result);
//            current[pos] = ')';
//            generateAll(current, pos + 1, result);
//        }
//    }
//
//    public boolean valid(char[] current) {
//        int balance = 0;
//        for (char c: current) {
//            if (c == '(') {
//                ++balance;
//            } else {
//                --balance;
//            }
//            if (balance < 0) {
//                return false;
//            }
//        }
//        return balance == 0;
//    }

    public static void main(String[] args) {
        System.out.println(new Top13_generateParenthesis().generateParenthesis(3));
        System.out.println(new Top13_generateParenthesis().generateParenthesis(3).size());
    }

    public List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new StringBuilder(),2*n, 0, combinations);
        return combinations;
    }

    private void generateAll(StringBuilder combination, int length, int pos, List<String> combinations) {
        if(pos == length){
            if(valid(combination.toString())){
                combinations.add(combination.toString());
            }

        }else{
            combination.append('(');
            generateAll(combination,length,pos+1,combinations);
            combination.deleteCharAt(pos);
            combination.append(')');
            generateAll(combination,length,pos+1,combinations);
            combination.deleteCharAt(pos);
        }
    }

    public boolean valid(String current) {
        int balance = 0;
        for(int i=0;i<current.length();i++){
            if(current.charAt(i)=='('){
                balance +=1;
            }else {
                balance -=1;
            }
            if(balance<0){
                return false;
            }
        }
        return balance==0;
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


}
