package com.hyy.leetcode.sort;

import java.util.Arrays;

/**
 * @program: LeetCodeStudy
 * @description: 快速排序
 * @author: hyy
 * @create: 2020-12-28 19:17
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7, 9, 5};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 相互交换
     * @param nums
     * @param left
     * @param right
     */
    private static void quickSort(int[] nums, int left, int right) {
        if(left>right){return;}

        int i = left, j = right;
        int target = nums[left];
        while (i<j){
            while (nums[j]>target&&i<j){
                j--;
            }
            while (nums[i]<=target&&i<j){
                i++;
            }
            if(i<j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        nums[left] = nums[i];
        nums[i] = target;

        System.out.println(Arrays.toString(nums));
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }
}
