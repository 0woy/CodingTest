package BinarySearch;

public class N_153 {
    private static int min;
    public static boolean checkIsMin(int [] nums, int idx){
        if(idx == nums.length-1||idx == 0) return false;
        return nums[idx] > nums[idx+1] || nums[idx]<nums[idx-1];
    }
    public static int binarySearch(int [] nums, int start, int end){
        if(start > end){
            return min;
        }
        int half = (start+end)/2;
        if(nums[half]<min){
            min = nums[half];
        }
         binarySearch(nums,half+1,end);
         binarySearch(nums,start,half-1);

        return min;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{11,13,15,17};
        min = Integer.MAX_VALUE;

        // the nums is sorted
        if(nums[0]<nums[nums.length-1]){
            System.out.println(nums[0]);
            return;
        }
        int res = binarySearch(nums,0,nums.length-1);
        System.out.println(res);


    }
}
