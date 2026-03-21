import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String [] clothe: clothes){
            map.put(clothe[1], map.getOrDefault(clothe[1],1)+1);
        }
        
        int answer = 1;
        for(int v: map.values()){
            answer*=v;
        }
        return answer-1;
    }
}