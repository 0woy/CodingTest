package Arrays_Hashing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer array nums,
return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class N_238 {
    public static void printArr(int [] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int [] nums = new int []{0,0};
        int [] result = new int[nums.length];
        List<Integer> zeroIdx = new ArrayList<>();

        boolean isZero = false;
        int total =1;

        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(val==0){
                isZero = true;
                zeroIdx.add(i);

                if(zeroIdx.size()>1){
                    printArr(result);
                    return;
                }
            }
            else{   total *= val;   }
        }
        if(isZero){
            result[zeroIdx.get(0)] = total;
            printArr(result);
            return;
        }

        for(int i=0;i<nums.length;i++){
            int div = nums[i];
            result[i] = total/div;
        }
        printArr(result);
        return;

    }
}
