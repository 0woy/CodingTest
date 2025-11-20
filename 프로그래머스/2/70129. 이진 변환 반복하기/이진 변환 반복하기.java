import java.util.*;
class Solution {
    public int[] solution(String s) {
        int zTotal = 0;
        int count=0;
        while(!s.equals("1")){
            int prev = s.length();
            s = s.replaceAll("0", "");
            int c= s.length();
            zTotal += prev-c;
            s = Integer.toBinaryString(c);            
            count++;
        }
        
        return new int[]{count, zTotal};
    }
}