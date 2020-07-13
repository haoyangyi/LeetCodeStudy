package com.hyy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 15
 * 三数之和
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int len=nums.length;
        if(nums==null||len<3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i=0;i<len-2;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = len-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];

                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }
            }
        }
        return ans;
    }

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        if(nums==null||nums.length<=2){
            return resultList;
        }
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>0){
                break;
            }
            for(int j=i+1;j<nums.length-1;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                for(int k=j+1;k<nums.length;k++){
                    if(k>j+1&&nums[k]==nums[k-1]){
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> ans=Arrays.asList(nums[i],nums[j],nums[k]);
                        resultList.add(ans);
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
