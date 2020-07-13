package com.hyy.leetcode.array;

/**
 * 	11
 * 盛最多水的容器
 */
public class MaxArea {
    public int maxArea1(int[] height) {
        int l=0;
        int r=height.length-1;
        int ans=0;
        while(l<=r){
            int result=Math.min(height[l],height[r])*(r-l);
            ans =Math.max(ans,result);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i <j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
