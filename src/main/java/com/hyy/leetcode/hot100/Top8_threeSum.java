package com.hyy.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeStudy
 * @description:
 * @author: hyy
 * @create: 2021-03-25 10:28
 *
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class Top8_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //判断数组为空和长度是否超过3
        if(nums==null||nums.length<3){
            return ans;
        }
        //数组排序
        Arrays.sort(nums);
        for(int first = 0;first<nums.length-2;first++){
            //如果第一个数大于0，后面3数之和只可能大于0，跳出
            if(nums[first]>0){
                break;
            }
            //第一个数重复则跳过
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            //双指针从头尾遍历
            int second = first+1;
            int third = nums.length-1;

            while (second<third){
                int sum = nums[first] + nums[second] + nums[third];
                if(sum==0){
                    //为0则加入数组
                    ans.add(Arrays.asList(nums[first],nums[second],nums[third]));
                    //第二个数重复则跳过
                    while(second<third&&nums[second]==nums[second+1]){
                        second++;
                    }
                    //第三个数重复则跳过
                    while(second<third&&nums[third]==nums[third-1]){
                        third--;
                    }
                    second++;
                    third--;
                }else if(sum>0){
                    third--;
                }else if(sum<0){
                    second++;
                }
            }
        }
        return ans;
    }
}
