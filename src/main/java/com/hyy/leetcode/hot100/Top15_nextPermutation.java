package com.hyy.leetcode.hot100;

/**
 * 31. 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class Top15_nextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }

        if(i>=0){
            int j = nums.length-1;
            while (j>=0&&nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }

        reverse(nums,i+1);
    }

    private void reverse(int[] nums, int start) {
        int left = start,right=nums.length-1;
        while(left<right){
            swap(nums,left,right);
            right--;
            left++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
