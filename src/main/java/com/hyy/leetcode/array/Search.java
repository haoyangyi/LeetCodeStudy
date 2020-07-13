package com.hyy.leetcode.array;

/**
 * 33
 * 搜索旋转排序数组
 */
public class Search {
    public int search(int[] nums, int target) {
        int len=nums.length;
        if(len==0) return -1;
        if(len==1) return nums[0]==target?0:-1;

        int left=0;
        int right=len-1;
        while(left<=right){
            int mid=(left+right)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[left]<=nums[mid]){
                if(nums[left]<=target&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{3,1},1));
    }
}
