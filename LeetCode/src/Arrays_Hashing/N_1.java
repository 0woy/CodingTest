package Arrays_Hashing;
/*
Given an array of integers nums and an integer target,
return indices of the two numbers
such that they add up to target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 */
public class N_1{
    public static void main(String[] args) {
        int[] nums = new int[]{-10,7,19,15};
        int target = 9;
        for (int i = 0; i <= nums.length-1; i++) {
            int flag = nums[i];
            for (int j = nums.length-1; j > i; j--) {
                if (flag + nums[j] == target) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}
