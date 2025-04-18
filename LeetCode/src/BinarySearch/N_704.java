package BinarySearch;
/** 문제
Given an array of integers nums which is sorted in ascending order,
 and an integer target,write a function to search target in nums.
 If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
 */
public class N_704 {
    public static int binarySearch(int [] nums, int start, int end,int target){
        if(start>end){
            return -1;
        }
        int half_idx = (start+end)/2;
        if(nums[half_idx] == target){
            return half_idx;
        }
        if(nums[half_idx]<target){
           return binarySearch(nums,half_idx+1, end, target);
        }
        else{
            return binarySearch(nums, start,half_idx-1, target);
        }

    }
    public static void main(String[] args) {
        int [] nums = new int[]{-1,0,3,5,9,12};
        int target = 2;
        int res = binarySearch(nums,0,nums.length,target);
        System.out.println(res);
    }
}
