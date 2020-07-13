package com.hyy.leetcode.array;

/**
 * 4
 * 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(new int[]{},new int[]{2,3}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int len=m+n;
        int left =0;
        int right=0;
        int i=0;
        int j=0;
        for(int k=0;k<=len/2;k++){
            left=right;
            if(i==m){
                right=nums2[j++];
                continue;
            }
            if(j==n){
                right=nums1[i++];
                continue;
            }
            if(nums1[i]<nums2[j]){
                right=nums1[i++];
            }else {
                right=nums2[j++];
            }
        }
        if(len%2==0){
            return (left+right)/2.0;
        }else {
            return right;
        }
    }
    /**
     * 暴力解法
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }



}
