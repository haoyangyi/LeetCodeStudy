package com.hyy.leetcode;

/**
 * 面试题53 - I
 * 在排序数组中查找数字 I
 */
public class Search {

    public int search(int[] nums, int target) {
        return searchOne(nums,target)-searchOne(nums,target-1);
    }

    public int searchOne(int[] nums, int target){
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]<=target){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i;
    }
}
