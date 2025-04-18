package DP;

public class N_198 {
    public static int rob(int[] nums) {
        int [] dp = new int[nums.length+2];
        dp[0]=0; dp[1]=0; dp[2]=nums[0];
        int max = nums[0];
        for(int i=1, idx=3;i<nums.length;i++, idx++){
            int cur = nums[i];
            dp[idx] = Math.max(dp[idx-2]+cur, dp[idx-1]-nums[i-1]+cur);
            max= Math.max(max, dp[idx]);
        }

        System.out.println("max = " + max);
        return max;
    }
    public static void main(String[] args){
        int []nums = new int[]{2,7,9,3,1};
        rob(nums);
    }
}
