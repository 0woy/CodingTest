package Arrays_Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums,
return true if any value appears at least twice in the array,
 and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
public class N_217 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> map = new HashMap<>();
        int[] ex1 =new int[]{1,2,3,1};
        for(int i=0;i<ex1.length;i++) {
            int tmp = map.getOrDefault(ex1[i],0);
            if(tmp >= 1){
                System.out.println("true: "+map.values());
                break;
            }
            map.put(ex1[i], map.getOrDefault(ex1[i],0)+1);
        }
        System.out.println("false: "+map.values());
    }
}
