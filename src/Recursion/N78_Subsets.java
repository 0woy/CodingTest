package Recursion;
/*
Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

- Example
 Input: nums = [1,2,3]
 Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

 Input: nums = [0]
 Output: [[],[0]]
 */
import java.io.IOException;
import java.util.*;

public class N78_Subsets {
    private static boolean [] visited;
    private static List<List<Integer>> list = new ArrayList<>();
    private static Set<Integer> set = new  HashSet<>();

    public static void main(String[] args) throws IOException {

      //  nums = new int []{1,2,3};
        int [] nums = new int []{0};
        visited = new boolean[nums.length];
        List<Integer>arr = new ArrayList<>();

        for(int i=1;i<=nums.length;i++){
            Recursion(arr, 0,i,0,nums);
        }

        list.add(new ArrayList<>());
        System.out.println(list);

    }

    public static void Recursion(List<Integer> arr, int depth, int m_len, int n_idx,int[]nums){
        if(depth== m_len){
            list.add(new ArrayList<>(arr));
            return;
        }
        for(int i=n_idx;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                arr.add(nums[i]);
                Recursion(arr, depth+1,m_len,i+1,nums);
                visited[i]=false;
                arr.remove(arr.size()-1);
            }
        }
    }
}
