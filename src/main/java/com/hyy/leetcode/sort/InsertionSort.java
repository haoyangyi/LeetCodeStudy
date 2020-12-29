package com.hyy.leetcode.sort;

import java.util.Arrays;

/**
 * @program: LeetCodeStudy
 * @description: 插入排序
 * @author: hyy
 * @create: 2020-12-28 14:03
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] insertionSort(int[] nums) {
        if(nums.length == 0){
            return nums;
        }
        int current;
        for(int i=0;i<nums.length-1;i++){
            current = nums[i+1];
            int preIndex = i;
            while(preIndex>=0&&nums[preIndex]>current){
                nums[preIndex+1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = current;
        }

        return nums;
    }
}
