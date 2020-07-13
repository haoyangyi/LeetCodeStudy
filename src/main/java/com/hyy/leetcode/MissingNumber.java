package com.hyy.leetcode;

/**
 * 面试题53 - II
 * 0～n-1中缺失的数字
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {

        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==mid){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(new int[]{1}));
    }
}
