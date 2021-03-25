package com.hyy.leetcode.array;

import java.util.Arrays;

/**
 * @program: LeetCodeStudy
 * @description: 归并排序
 * @author: hyy
 * @create: 2020-12-24 17:25
 */
public class MergeSort1 {


    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        mergeSort1(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort1(int[] nums, int left, int right) {
        if(left >= right){return;}
        int mid = (left + right)/2;
        mergeSort1(nums,left,mid);
        mergeSort1(nums,mid+1,right);
        merge1(nums,left,mid,right);
    }

    private static void merge1(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right-left+1];
        int i=left,j=mid+1,k=0;

        //同时遍历 前半数组 和 后半数组
        while(i<=mid && j<=right){
            if(nums[i]< nums[j]){
                tmp[k++] = nums[i++];
            }else {
                tmp[k++] = nums[j++];
            }
        }

        //前半数组遍历
        while(i<=mid){
            tmp[k++] = nums[i++];
        }

        //后半数组遍历
        while (j<=right){
            tmp[k++] = nums[j++];
        }

        System.out.println(Arrays.toString(tmp));

        for(int l =0;l<=tmp.length-1;l++){
            nums[left+l] = tmp[l];
        }
    }
}
