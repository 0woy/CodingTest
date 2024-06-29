package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/** 문제
Given a string s, find the length of the longest
substring without repeating characters

ex)
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring

 */
public class N_3 {
    /**public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        int maxLen=0;
        StringBuilder sb =new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int idx =1;
        for(char c : s.toCharArray()){
            int prevIdx = map.getOrDefault(c, -1);
            // 존재하는 경우
            if(prevIdx!=-1){
                maxLen = maxLen<len?len:maxLen;
                sb.delete(0,prevIdx);
                setMap(sb, map);
            }
            sb.append(c);
            map.put(c,idx++);
            len++;
        }
        maxLen = maxLen<len?len:maxLen;
        return maxLen;
    }
     */

    public static int lengthOfLongestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for(int right = 0; right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "abcdacef";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
