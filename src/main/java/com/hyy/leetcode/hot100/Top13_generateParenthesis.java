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

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
//            if (valid(current)) {
                result.add(new String(current));
//            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Top13_generateParenthesis().generateParenthesis(1));
        System.out.println(new Top13_generateParenthesis().generateParenthesis(1).size());
    }
}
