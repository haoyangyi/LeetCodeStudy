package com.hyy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 	1
 * 两数之和
 */
public class TwoSum {

    /**
     * 数组双重遍历
     * 时间复杂度是 O(nlogn)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] indexs = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    indexs[0]=i;
                    indexs[1]=j;
                    break;
                }
            }
        }
        return indexs;
    }

    /**
     *
     * 数组字典
     * 时间复杂度是 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer,Integer> resultMap = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(resultMap.containsKey(nums[i])){
                index[0]=resultMap.get(nums[i]);
                index[1]=i;
                break;
            }
            resultMap.put(target-nums[i],i);
        }
        return index;
    }
}
