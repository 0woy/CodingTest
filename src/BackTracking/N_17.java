package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 문제
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class N_17 {
    public static List<String> result;
    public static Map<Character, List<Character>> map;
    public static String target;
    public static StringBuilder sb;


    public static void setMap(){
        char alpha = 'a';
        for(char i='2';i<='9';i++){
            if(i=='7'||i=='9'){
                map.put(i, addList(alpha,4));
                alpha+=4;
            }
            else{
                map.put(i, addList(alpha,3));
                alpha+=3;
            }
        }
    }
    public static List<Character> addList(char start, int len){
        List<Character> arr = new ArrayList<>();
        for(int count=0;count<len;count++) {
            arr.add(start++);
        }
        return arr;
    }

    public static void addLetters(List<Character> arr, int curIdx){
        int idx=0;
        while(idx<arr.size()){
            sb.append(arr.get(idx));
            if(sb.length() == target.length()){
                result.add(sb.toString());
                sb.deleteCharAt(sb.length()-1);
            }
            else {
                addLetters(getArray(target.charAt(++curIdx)),curIdx);
                sb.deleteCharAt(sb.length()-1);
                curIdx--;
            }
            idx++;
        }
    }

    public static List<Character> getArray(char key){
        return map.get(key);
    }

    public static void main(String[] args) {
        String digits = "234";

        if(digits.length()==0){
            return;
        }
        sb =new StringBuilder();
        target=digits;
        map = new HashMap<>();
        result= new ArrayList<>();
        setMap();

        addLetters(getArray(digits.charAt(0)),0);
        System.out.println(result.toString());

    }
}
