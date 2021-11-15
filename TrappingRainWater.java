package Leetcode;

class TrappingRainWater {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minLR = new int[height.length];
        
        maxLeft[0] = 0;
        maxRight[height.length-1] = 0;
        
        for (int i = 1; i < maxLeft.length; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        
        for (int i = maxRight.length-2; i > -1; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        
        for (int i = 0; i < minLR.length; i++){
            minLR[i] = Math.min(maxLeft[i], maxRight[i]);
        }
        
        int water = 0;
        
        for (int i = 0; i < height.length; i++){
            int diff = minLR[i] - height[i];
            if (diff >= 0){
                water += diff;
            }
        }
        
        return water;
    }
}
