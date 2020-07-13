package com.hyy.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 	56
 * 合并区间
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> result= new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int j=-1;
        for(int i=0;i<intervals.length;i++){
            if(i==0||result.get(j)[1]<intervals[i][0]){
                j++;
                result.add(intervals[i]);
            }else{
                result.get(j)[1]=Math.max(result.get(j)[1],intervals[i][1]);
            }
        }
        return result.toArray(new int[0][]);

    }



    public int[][] merge1(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int j=-1;
        for(int i=0;i<intervals.length;i++){
            if(i==0||result[j][1]<intervals[i][0]){
                result[++j]=intervals[i];
            }else{
                result[j][1]=Math.max(result[j][1],intervals[i][1]);
            }
        }
        return Arrays.copyOf(result,j+1);
    }
}
