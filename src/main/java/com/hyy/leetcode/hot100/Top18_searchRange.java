package com.hyy.leetcode.hot100;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Top18_searchRange {
    public int[] searchRange1(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        if(nums==null||nums.length==0){return ans;}
        int left = 0,right =nums.length-1;
        if(nums[left]>target||nums[right]<target){
            return ans;
        }
        while(left<=right){
            if(nums[left]<target){
                left++;
            }
            if(nums[right]>target){
                right--;
            }
            if(nums[left]==target&&nums[right]==target){
                ans[0] = left;
                ans[1] =right;
                break;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
