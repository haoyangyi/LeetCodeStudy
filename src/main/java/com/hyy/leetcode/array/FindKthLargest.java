package com.hyy.leetcode.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 	215
 * 数组中的第K个最大元素
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        return a-b;
                    }
                });
        for(int n:nums){
            heap.add(n);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.poll();
    }
}
