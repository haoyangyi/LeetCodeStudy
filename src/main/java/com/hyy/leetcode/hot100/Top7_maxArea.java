package com.hyy.leetcode.hot100;

/**
 * @program: LeetCodeStudy
 * @description:
 * @author: hyy
 * @create: 2021-03-24 17:55
 * 盛最多水的容器
 */
public class Top7_maxArea {
    public int maxArea(int[] height) {
        int left =0,right=height.length-1,res=0;
        while(left<right){
            res = height[left]<height[right]?
                    Math.max(res,(right-left)*height[left++]):
                    Math.max(res,(right-left)*height[right--]);
        }
        return res;
    }
}
