package Arrays_Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public static int strToAscii(String str){
        int sum=0;
        for(int i=0;i<str.length();i++){
            sum+=str.charAt(i);
        }
        return sum;
    }
    public static void main(String[] args) {
        String[] strs = new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        List<Boolean> check = new ArrayList<>();
        for(String str: strs){
            check.add(false);
        }
        List<List<String>> answer = new ArrayList<>();

        for(int i=0;i<strs.length;i++){
            List<String> list = new ArrayList<>();
            String flag = strs[i];
            if(check.get(i)){
                continue;
            }
            list.add(flag);
            int strInt = strToAscii(flag);
            check.set(i,true);
            for(int j=i+1;j<check.size();j++) {
                // true인 경우 (이미 다른 list에 속한 경우)
                if (check.get(j)) continue;
                int fInt = strToAscii(strs[j]);
                if(strInt==fInt){
                    check.set(j,true);
                    list.add(strs[j]);
                }
            }
            answer.add(list);
        }
    }
}
