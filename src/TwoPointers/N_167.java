package TwoPointers;
/**
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 find two numbers such that they add up to a specific target number.
 Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

 Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

 The tests are generated such that there is exactly one solution. You may not use the same element twice.
 Your solution must use only constant extra space.
*/
public class N_167 {
    public static int findLastIdx(int[] numbers, int start, int end, int target){
        if(start >= end) return end;
        int halfIdx = (start+end)/2;
        if(numbers[halfIdx]<=target){
            start=halfIdx+1;
            return findLastIdx(numbers,start,end,target);
        }
        else{
            end=halfIdx-1;
            return findLastIdx(numbers,start,end,target);
        }
    }
    public static int[] findTwoSum(int[]numbers, int end, int target){
        int start =0;
        while(start<end) {
            for (int i = end; i >= start; i--) {
                if (numbers[start] + numbers[i] == target) {
                    return new int[]{start+1, i+1};
                }
                if (numbers[start] + numbers[i] < target) {
                    break;
                }
            }
            start++;
        }
        return null;
    }
    public static void main(String[] args) {
        int [] numbers = new int[]{-1,-1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = -2;
        int lastIdx = findLastIdx(numbers,0,numbers.length-1,target-numbers[0]);
        int [] res = findTwoSum(numbers,lastIdx,target);
        System.out.println(res[0]+" "+res[1]);

    }

}
