package com.hyy.leetcode.array;

import java.util.Arrays;

/**
 * @program: LeetCodeStudy
 * @description: 快速排序
 * @author: hyy
 * @create: 2020-12-24 18:01
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7, 9, 5};
        quickSort(nums, 0, nums.length-1);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 填坑
     * @param nums
     * @param low
     * @param high
     */
    private static void quickSort1(int[] nums, int low, int high) {
        if(low>high){
            return;
        }
        int i = low, j = high;
        int targe = nums[low];

        while (i<j){
            while(nums[j]>targe&&i<j){
                j--;
            }
            if(i<j){
                nums[i] = nums[j];
                i++;
            }
            while(nums[i]<=targe&&i<j){
                i++;
            }

            if(i<j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = targe;
        quickSort1(nums,low,i-1);
        quickSort1(nums,i+1,high);
    }
    /**
     * 交换
     * @param nums
     * @param low
     * @param high
     */
    private static void quickSort(int[] nums, int low, int high) {
        if(low>high){
            return;
        }
        int i = low, j = high;
        int targe = nums[low];
        while(i<j){

            while(nums[j]>targe&&i<j){
                j--;
            }
            while(nums[i]<=targe&&i<j){
                i++;
            }
            if(i<j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        nums[low] = nums[i];
        nums[i] = targe;

//        System.out.println(Arrays.toString(nums));

        quickSort(nums, low, i-1);
        quickSort(nums, i+1, high);
    }
}
