package Leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        
        int i = 0; //left pointer
        int j = height.length - 1; //right pointer
        
        while (i < j){
            int leftHeight = height[i];
            int rightHeight = height[j];
            
            int base = j - i;
            int minHeight = Math.min(leftHeight, rightHeight);
            
            int area = base*minHeight;
            
            maxArea = Math.max(maxArea, area);
            
            if (leftHeight < rightHeight){
                i++;
            } else{
                j --;
            }
        }
        
        return maxArea;       
    }
}
