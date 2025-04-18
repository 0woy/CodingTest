package DP;

import java.util.Arrays;

public class N_238 {
    /** O(N+N), Space Complexity: O(N+N)
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] prefix = new int[len];
        int [] suffix = new int[len];
        prefix[0]=1;
        suffix[len-1]=1;

        for(int i=1;i<len;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
            suffix[len-i-1]=suffix[len-i]*nums[len-i];
        }
        int [] answer = new int[len];
        for(int i=0;i<len;i++){
            answer[i] = prefix[i]*suffix[i];
        }
        for(int v: answer){
            System.out.print(v+" ");
        }
        return answer;
    }
     */

    public static int[] productExceptSelf(int[] nums) {
        int [] answer =new int[nums.length];
        Arrays.fill(answer, 1);
        int cur = 1;
        for(int i=0;i<nums.length;i++){
            answer[i]*=cur;
            cur*=nums[i];
        }
        cur = 1;
        for(int i=nums.length-1;i>=0;i--){
            answer[i]*=cur;
            cur *=nums[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] nums =new int[]{-1,1,0,-3,3};
        productExceptSelf(nums);
    }
}
