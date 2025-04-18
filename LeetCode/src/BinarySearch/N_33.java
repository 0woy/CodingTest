package BinarySearch;
/** 문제 설명
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function,
nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target,
return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */
public class N_33 {
    private static int target;
    public static int binarySearch(int [] nums, int start, int end){
        if(start>end){
            return -1;
        }
        int half=  (start+end)/2;
        if(nums[half]==target){
            return half;
        }
        int back = binarySearch(nums,start,half-1);
        int front = binarySearch(nums,half+1,end);
        if(back!=-1){return back;}
        if(front!=-1){return front;}
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        target = 3;
        int res = binarySearch(nums,0,nums.length-1);
        System.out.println(res);
    }
}
