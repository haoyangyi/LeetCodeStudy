package com.hyy.leetcode.hot100;

/**
 * @program: LeetCodeStudy
 * @description:
 * @author: hyy
 * @create: 2021-03-24 10:27
 *
 * 寻找两个正序数组的中位数
 */
public class Top4_findMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = 0;

        for(int i=0,j=0,k=0;k<=(m+n)/2;k++){
            left = right;
            if(i<m&&j<n){
                right = nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
            }else if(i<m){
                right = nums1[i++];
            }else if(j<n){
                right = nums2[j++];
            }
        }
        if((m+n)%2==0){
            return (left+right)/2.0;
        }else {
            return right;
        }
    }
}
