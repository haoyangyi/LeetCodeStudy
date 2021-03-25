package com.hyy.leetcode.array;

/**
 * @program: LeetCodeStudy
 * @description: 递归数组求和
 * @author: hyy
 * @create: 2020-12-23 19:44
 */
public class SumArr {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int result = sum(arr,0);
        System.out.println(result);

    }

    private static int sum(int[] arr, int begin) {
        if(begin == arr.length-1){
            return arr[begin];
        }else {
            return arr[begin] + sum(arr, begin+1);
        }
    }
}
