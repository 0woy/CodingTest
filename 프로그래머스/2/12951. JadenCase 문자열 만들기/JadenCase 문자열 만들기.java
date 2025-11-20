import java.util.*;
class Solution {
    public String solution(String s) {
        int i=0;
        StringBuilder sb = new StringBuilder(s.toLowerCase());        
        while(i<s.length()){
            if(s.charAt(i)==' '){
                while(i<s.length() && s.charAt(i)==' ') {i++;}    
            }                        
            // 단어의 첫 글자가 숫자인 경우
            if(i<s.length() && Character.isDigit(s.charAt(i))){                
                while(i<s.length() && s.charAt(i)!=' '){i++;}
            }
            
            else{
                if(i<s.length()){
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                while(i<s.length() &&s.charAt(i)!=' '){i++;}
                    
                }
            }
        }
        return sb.toString();
    }
}