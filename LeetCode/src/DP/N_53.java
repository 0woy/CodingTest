package DP;

public class N_53 {
    /** Using dp[]
    public static int maxSubArray(int[] nums) {
        int [] dp = new int[nums.length+1];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i< nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
     */
    public static int maxSubArray(int[] nums) {
        int c_max =nums[0];
        int g_max =nums[0];
        for(int i=1;i< nums.length;i++){
            c_max =  Math.max(nums[i]+c_max, nums[i]);
            g_max =  Math.max(g_max, c_max);
        }
        return g_max;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
}
