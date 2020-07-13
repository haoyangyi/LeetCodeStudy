package com.hyy.leetcode.array;

/**
 * 121
 * 买卖股票的最佳时机
 */
public class MaxProfit {
    public int maxProfit1(int[] prices) {
        int ans=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i;j<prices.length;j++){
                ans=Math.max(ans,prices[j]-prices[i]);
            }
        }
        return ans;
    }

    public int maxProfit(int[] prices) {
        int ans=0;
        int minPrice=Integer.MAX_VALUE;
        for(int price:prices){
            if(price<minPrice){
                minPrice=price;
            }else if(price-minPrice>ans){
                ans=price-minPrice;
            }
        }
        return ans;
    }
}
