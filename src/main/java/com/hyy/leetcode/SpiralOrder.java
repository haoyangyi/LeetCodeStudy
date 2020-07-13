package com.hyy.leetcode;

import java.util.Arrays;

/**
 * 面试题29. 顺时针打印矩阵
 */
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];

        int t=0;
        int b=matrix.length-1;
        int l=0;
        int r=matrix[0].length-1;

        int[] result=new int[(b+1)*(r+1)];
        int x=0;
        while(true){
            //上面 左往右
            for(int i=l;i<=r;i++){result[x++]=matrix[t][i];}
            if(++t>b) break;
            //右边 上往下
            for(int i=t;i<=b;i++){result[x++]=matrix[i][r];}
            if(--r<l) break;
            //下面 右往左
            for(int i=r;i>=l;i--){result[x++]=matrix[b][i];}
            if(--b<t) break;
            //左边 下往上
            for(int i=b;i>=t;i--){result[x++]=matrix[i][l];}
            if(++l>r) break;
        }
        return result;
    }

    public static void main(String[] args) {

       int[] result= new SpiralOrder().spiralOrder(new int[][]{
                {3},{2}
        });
        System.out.println(result);
    }
}
