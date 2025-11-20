import java.util.*;
class Solution {
    public int[] solution(String s) {
        int [] answer =new int[2];
        while(!s.equals("1")){
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            int c= s.length();
            s = Integer.toBinaryString(c);            
            answer[1]-=c;
            answer[0]++;
        }
        
        return answer;
    }
}