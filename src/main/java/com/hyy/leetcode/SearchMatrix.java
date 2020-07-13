package com.hyy.leetcode;

/**
 * 240
 * 搜索二维矩阵 II
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length-1;
        int col=0;
        while(row>=0&&col<matrix[0].length){
            if(matrix[row][col]>target){
                row--;
            }else if(matrix[row][col]<target){
                col++;
            }else {
                return true;
            }
        }
        return false;
    }

}
