package com.hyy.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 406
 * 根据身高重建队列
 */
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        LinkedList<int[]> output=new LinkedList<>();
        for(int[] p:people){
            output.add(p[1],p);
        }
        return output.toArray(new int[people.length][2]);
    }
}
