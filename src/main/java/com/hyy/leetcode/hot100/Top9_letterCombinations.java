package com.hyy.leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetCodeStudy
 * @description:
 * @author: hyy
 * @create: 2021-03-25 15:08
 *  17. 电话号码的字母组合
 *  https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Top9_letterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits.length()==0){
            return combinations;
        }
        Map<Character,String> phoneMap = new HashMap<>();
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");
        backtrack(combinations,digits,phoneMap,0,new StringBuilder());
        return combinations;
    }

    private void backtrack(List<String> combinations, String digits, Map<Character, String> phoneMap, int index, StringBuilder combination) {
        if(index==digits.length()){
            combinations.add(combination.toString());
        } else {
            Character digit = digits.charAt(index);
            String digitLetter = phoneMap.get(digit);
            for(int i = 0;i<digitLetter.length();i++){
                combination.append(digitLetter.charAt(i));
                backtrack(combinations,digits,phoneMap,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Top9_letterCombinations().letterCombinations("23"));
    }
}
