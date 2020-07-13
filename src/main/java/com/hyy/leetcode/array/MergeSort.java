package com.hyy.leetcode.array;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] nums,int left,int right){
        if(left>=right){return;}
        int mid=(left+right)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right-left+1];
        int i=0;
        int center=mid+1;
        while(left<=mid&&center<=right){
            if(nums[left]<nums[center]){
                tmp[i]=nums[left];
                i++;
                left++;
            }else{
                tmp[i]=nums[center];
                i++;
                center++;
            }
        }
        while (left<=mid){
            tmp[i]=nums[left];
            i++;
            left++;
        }
        while (center<=right){
            tmp[i]=nums[center];
            i++;
            center++;
        }

        for(int j=tmp.length-1;j>=0;j--){
            nums[right]=tmp[j];
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
