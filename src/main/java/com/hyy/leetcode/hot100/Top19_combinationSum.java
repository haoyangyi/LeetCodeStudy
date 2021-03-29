package com.hyy.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 9. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class Top19_combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        //直接跳过
        dfs(candidates, target, ans, combine, index+1);
        // 选择当前数
        if(target - candidates[index]>=0){
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], ans, combine, index);
            combine.remove(combine.size()-1);
        }
    }


}
