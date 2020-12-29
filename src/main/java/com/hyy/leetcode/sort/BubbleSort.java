package com.hyy.leetcode.sort;

import java.util.Arrays;

/**
 * @program: LeetCodeStudy
 * @description: 冒泡排序
 * @author: hyy
 * @create: 2020-12-28 11:59
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] bubbleSort(int[] nums) {
        if(nums.length == 0){
            return nums;
        }
        for(int i = 0;i< nums.length;i++){
            for(int j = 0;j< nums.length-i-1;j++){
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        return nums;
    }

}
