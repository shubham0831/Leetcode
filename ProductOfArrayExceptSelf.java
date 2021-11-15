package Leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int totalMul = 1;
        boolean containsZero = false;
        int zeroCount = 0;
        
        for (int n : nums){
            if (n != 0){
                totalMul *= n;
            }
            
            boolean isZero = (n == 0);
            containsZero = (containsZero || isZero);
            
            if (isZero){
                zeroCount ++;
            }
        }
        
        int [] sol = new int[nums.length];
        Arrays.fill(sol, 0);
        
        if (zeroCount > 1){
            return sol;
        }       
    
        for (int i = 0; i < sol.length; i++){
            if (containsZero){
                if (nums[i] != 0){
                    sol[i] = 0;
                } else {
                    sol[i] = totalMul;
                }
            } else {
                sol[i] = totalMul / nums[i];
            }           
        }
        
        return sol;
    }
}
