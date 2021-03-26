package com.hyy.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeStudy
 * @description:
 * @author: hyy
 * @create: 2021-03-23 18:17
 *
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Top3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int start = 0,end =0;end < s.length(); end++){
            char alpha = s.charAt(end);
            if(map.containsKey(alpha)){
                start = Math.max(map.get(alpha),start);
            }
            map.put(s.charAt(end),end+1);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new Top3_lengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}
