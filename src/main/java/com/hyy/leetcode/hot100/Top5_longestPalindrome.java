package com.hyy.leetcode.hot100;

/**
 * @program: LeetCodeStudy
 * @description:
 * @author: hyy
 * @create: 2021-03-24 11:45
 *
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Top5_longestPalindrome {
    /**
     * 暴力破解
     * 双指针遍历2边夹
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int len = s.length();
        if(len<2){
            return s;
        }
        int begin = 0;
        int maxLen = 1;
        for(int i=0;i<len-1;i++){

            for(int j = i;j<len;j++){
                if(j-i+1>maxLen && validPalindromic(s,i,j)){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }

    private boolean validPalindromic(String s, int left, int right) {
        while(left < right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 中心扩散
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++){
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    /**
     * 中心点扩散找到最大长度回文字符串
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(String s, int left, int right) {
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
