package com.hyy.leetcode.array;

/**
 * 面试题03. 数组中重复的数字
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int temp=-1;
        for(int i=0;i<nums.length;i++){

            while (nums[i] != i) {
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindRepeatNumber().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
