package com.hyy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 253
 * 会议室 II
 */
public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        PriorityQueue<Integer> allocator=new PriorityQueue<>(intervals.length,(a,b)->(a-b));
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        allocator.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=allocator.peek()){
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
    /**
     * 题目就是要统计同一时刻进行的最大会议的数量
     * 我们可以把所有的开始时间和结束时间放在一起排序，
     * 用cur表示当前进行的会议数量，遍历排序后的时间数组
     * 如果是开始时间，cur加1，如果是结束时间，cur减一
     * 在遍历的过程中，cur出现的最大值就是需要的房间数。
     *
     *
     * @return
     */
    public int minMeetingRooms1(int[][] intervals) {
        int[][] events=new int[intervals.length*2][2];
        int i=0;
        for(int[] interval:intervals){
            events[i][0]=interval[0];
            events[i][1]=1;
            i++;
            events[i][0]=interval[1];
            events[i][1]=-1;
            i++;
        }
        Arrays.sort(events,(a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);

        int ans=0;
        int cur=0;
        for(int[] even:events){
            cur=cur+even[1];
            ans=Math.max(ans,cur);
        }
        return ans;
    }
}
