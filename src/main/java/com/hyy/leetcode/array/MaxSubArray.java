package com.hyy.leetcode.array;

/**
 * 53
 * 最大子序和
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int pre=0;
        for(int num:nums){
            pre=Math.max(pre+num,num);
            ans=Math.max(ans,pre);
        }
        return ans;
    }

    public int maxSubArray1(int[] nums) {
        int ans=nums[0];
        int pre=0;
        for(int num:nums){
            if(pre<0){
                pre=num;
            }else{
                pre+=num;
            }
            ans=Math.max(ans,pre);
        }
        return ans;
    }
}
