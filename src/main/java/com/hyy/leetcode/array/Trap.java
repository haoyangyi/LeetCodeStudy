package com.hyy.leetcode.array;

/**
 * 	42
 * 接雨水
 */
public class Trap {
    /**
     * 暴力解法
     * 时间O(N^2)  空间O(1)
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int total = 0;
        for(int i=0;i<height.length;i++){
            int value=height[i];
            int leftMaxValue=0;
            int rightMaxValue=0;
            int resultMaxValue=0;

            for(int j=0;j<=i;j++){
                leftMaxValue = leftMaxValue>=height[j]?leftMaxValue:height[j];
            }

            for(int k=i;k<height.length;k++){
                rightMaxValue = rightMaxValue>=height[k]?rightMaxValue:height[k];
            }
            resultMaxValue = leftMaxValue<=rightMaxValue?leftMaxValue:rightMaxValue;
            total+=resultMaxValue-value;
        }
        return total;
    }

    /**
     * 时间O(N) 空间O(N)
     * 动态规划
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if(height.length==0){
            return 0;
        }

        int total = 0;
        int [] left = new int[height.length];
        int [] right = new int[height.length];
        left[0]=height[0];
        right[height.length-1]=height[height.length-1];

        for(int i=1;i<height.length;i++){
            left[i] = Math.max(height[i],left[i-1]);
        }
        for(int j=height.length-2;j>=0;j--){
            right[j] = Math.max(height[j],right[j+1]);
        }
        for(int k=0;k<height.length-1;k++){
            total+=Math.min(left[k],right[k])-height[k];
        }
        return total;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Trap().trap(height));
    }
}
