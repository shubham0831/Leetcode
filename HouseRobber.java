package Leetcode;

class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        
        int[] dp = new int[nums.length+1];
        
        for (int i = 1; i < dp.length; i++){
            dp[i] = nums[i-1];
        }
        
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        
        for (int i = 3; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i]+dp[i-2]);
        }
        
        return Math.max(dp[dp.length-1], dp[dp.length-2]);
    }
}
