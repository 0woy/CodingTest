package Arrays_Hashing;

import java.util.Arrays;

/*
Given an unsorted array of integers nums,
return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */
public class N_128 {
    public static void main(String[] args) {
        int[]nums = new int[]{1,2,0,1,1,1,1};
        Arrays.sort(nums);
        int max=0;
        if(nums.length==0){
            System.out.println(max);
            return;
        }
        int count =1;
        for(int i=0;i<nums.length-1;i++){
            int cur = nums[i];
            int next = nums[i+1];
            if(cur+1 == next) {
                count++;
            }
            else if(cur == next){
                continue;
            }
            else {
                if(max < count) max = count;
                count =1;
            }
        }
        if(max < count) max =count;
        System.out.println(max);
    }
}
