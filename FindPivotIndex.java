package Leetcode;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int n : nums){
            totalSum += n;
        }
        
        int currentSum = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++){
            int currentEl = nums[i];
            if (totalSum - currentEl - currentSum == currentSum){
                index = i;
                break;
            } else {
                currentSum += currentEl;
            }
        }
        
        return index;
    }    
}
