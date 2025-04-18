package Arrays_Hashing;

import java.util.*;

/*
Given two strings s and t,
return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase
formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
 */
public class N_242 {
    public static boolean main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String s = "cat", t = "rat";
        for(int i =0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<t.length();i++){
            if(map.getOrDefault(t.charAt(i),0)==0){
                return false;
            }
            map.put(t.charAt(i), map.get(t.charAt(i))-1);
        }

        List<Character> keySet = new ArrayList<>(map.keySet());

        // 내림차순 정렬
        keySet.sort((o1,o2)-> map.get(o2).compareTo(map.get(o1)));
        for(Character key: keySet){
            if(map.get(key)>0){
                return false;
            }
        }

        return true;
    }
}
