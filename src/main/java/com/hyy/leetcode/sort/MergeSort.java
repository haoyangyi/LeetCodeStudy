package com.hyy.leetcode.sort;

import java.util.Arrays;

/**
 * @program: LeetCodeStudy
 * @description: 归并排序
 * @author: hyy
 * @create: 2020-12-28 19:07
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if(left >= right){return;}
        int mid = (left+right)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] tmps = new int[right-left+1];
        int i = left, j = mid+1,k=0;
        while(i<=mid&&j<=right){
            if(nums[i]<nums[j]){
                tmps[k++] = nums[i++];
            } else {
                tmps[k++] = nums[j++];
            }
        }

        while(i<=mid){
            tmps[k++] = nums[i++];
        }

        while(j<=right){
            tmps[k++] = nums[j++];
        }

        for(int l=0;l<=tmps.length-1;l++){
            nums[left+l] = tmps[l];
        }
    }
}
