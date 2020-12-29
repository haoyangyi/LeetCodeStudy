package com.hyy.leetcode.sort;

import java.util.Arrays;

/**
 * @program: LeetCodeStudy
 * @description: 选择排序
 * @author: hyy
 * @create: 2020-12-28 12:07
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] selectionSort(int[] nums) {
        if(nums.length == 0){
            return nums;
        }
        for(int i = 0;i< nums.length;i++){
            int minIndex = i;
            for(int j = i;j<nums.length;j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }
        return nums;
    }

}
