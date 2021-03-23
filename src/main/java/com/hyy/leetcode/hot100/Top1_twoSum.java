package com.hyy.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeStudy
 * @description:
 * @author: hyy
 * @create: 2021-03-23 17:15
 *
 */
public class Top1_twoSum {
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numMap.put(target-nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            if(numMap.containsKey(nums[i])&&i!=numMap.get(nums[i])){
                return new int[]{i,numMap.get(nums[i])};
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(numMap.containsKey(nums[i])){
                return new int[]{numMap.get(nums[i]),i};
            }
            numMap.put(target-nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
