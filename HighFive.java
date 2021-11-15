package Leetcode;

import java.util.Arrays;

class HighFive {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10005];
        Arrays.fill(sum,0);
        for (int i = 0; i < nums.length; ++i){
            sum[nums[i]] += nums[i];
        }
        
        int[] dp = new int[10005];
        
        dp[1] = sum[1];
        dp[2] = Math.max(sum[1], sum[2]);
        
        for (int i = 3; i < 10005; ++i){
            dp[i] = Math.max(dp[i-1], sum[i] + dp[i-2]);
        }
        
        int maxPoints = Math.max(dp[sum.length-1], dp[sum.length-2]);
        return maxPoints;
    }
}