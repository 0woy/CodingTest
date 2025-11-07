import java.util.*;
class Solution {
    static Map<String, Integer> map;
    static Map<String, Integer> check;
    
    public int solution(String[] want, int[] number, String[] discount) {
        map = new HashMap<>();
        check = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i], number[i]);            
        }        
        for(int i=0;i<10;i++){
            check.put(discount[i], check.getOrDefault(discount[i],0)+1);
        }        

        int answer = 0;    
        int firstIdx = 0;
        for(int i=10;i<discount.length;i++){
            answer+=isMatch();
            check.compute(discount[i-10], (k,v)->
                         (v==null || v==1)?null:v-1);
            check.merge(discount[i], 1, Integer::sum);            
        }           
        answer+=isMatch();
        
        
        
        return answer;
    }
    public int isMatch(){
        for(String key : check.keySet()){
            if(!map.containsKey(key) || map.get(key) != check.get(key)) 
                return 0;
        }
        return 1;
    }
}