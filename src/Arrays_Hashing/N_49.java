package Arrays_Hashing;

import java.sql.Array;
import java.util.*;

/*
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

 */
public class N_49 {
    public static String sortString(String str){
        char [] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);

    }
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            String sortedStr = sortString(str);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr,new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
       // return new ArrayList<>(map.values());

    }
}
