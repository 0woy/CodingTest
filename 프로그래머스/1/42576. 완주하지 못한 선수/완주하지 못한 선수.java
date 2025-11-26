import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {        
        Map<String, Integer> checkComp= new HashMap<>();
        
        for(String part : participant){
            checkComp.put(part, checkComp.getOrDefault(part, 0)+1);
        }
        
        for(String comp: completion){
            checkComp.put(comp, checkComp.get(comp)-1);
            if(checkComp.get(comp)==0){
                checkComp.remove(comp);
            }
        }
        
        return checkComp.keySet().iterator().next();
        // return "1";
    }
}