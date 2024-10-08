package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class N_15 {
    /** First Try : Not yet
    public static int findIdx(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int half = (start+end)/2;
            if(nums[half]==0){return half;}
            else if(nums[half]>0){
                end = half-1;
            }
            else{
                start =half-1;
            }
        }
        return start;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        boolean isZero =  false;
        Arrays.sort(nums);
        if(nums[0]==0 && nums[nums.length-1]==0){
            return null;
        }
        if(nums[0]>0 || nums[nums.length-1]<0){
            return null;
        }
        int flag = findIdx(nums);
        if(nums[flag]==0){
            isZero = true;
            flag++;
        }
        else if(nums[flag]<0){
            flag++;
        }
        List<Integer> minus = Arrays.stream(Arrays.copyOfRange(nums, 0,flag))
                                .boxed()
                                .collect(Collectors.toList());

        List<Integer> plus = Arrays.stream(Arrays.copyOfRange(nums, flag, nums.length))
                            .boxed()
                            .collect(Collectors.toList());

        return null;

    }
     */
    public static int findIdx(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int half = (start+end)/2;
            if(nums[half]==0){ return half;}
            else if(nums[half]<0){
                start =  half+1;
            }
            else{
                end = half-1;
            }
        }
        return start;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int lastIdx = findIdx(nums);
        if(lastIdx <0) lastIdx++;
        if(nums[0]>0 || nums[nums.length]<0) return null;

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<lastIdx;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int total  = nums[i]+nums[j]+nums[k];
                if(total<0){
                    j++;
                }else if( total>0){
                    k--;
                }else{
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(nums[j]==nums[j-1] && j<k){
                        j++;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        threeSum(new int[]{-1,-2,0,-4,2,1});
    }
}
