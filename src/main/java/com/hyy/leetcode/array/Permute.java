package com.hyy.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 	46
 * 全排列
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> list,int[] nums){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int num:nums){
            if(!list.contains(num)){
                list.add(num);
                backtrack(res,list,nums);
                list.remove(list.size()-1);
            }
        }
    }
}
