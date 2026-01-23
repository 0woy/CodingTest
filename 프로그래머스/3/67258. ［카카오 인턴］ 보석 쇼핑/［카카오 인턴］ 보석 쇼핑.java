import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int total = new HashSet<>(Arrays.asList(gems)).size();
        Map<String, Integer> map = new HashMap<>();
        
        int minLen = Integer.MAX_VALUE;
        int l=0;
        int[] answer = new int[2];
        
        for(int r=0;r<gems.length;r++){
            map.put(gems[r], map.getOrDefault(gems[r],0)+1);
            
            while(map.size()==total){
                if(minLen > (r-l)){
                    minLen = r-l;
                    answer[0]=l+1;
                    answer[1]=r+1;
                }
                map.put(gems[l], map.get(gems[l])-1);
                if(map.get(gems[l])==0) map.remove(gems[l]);
                l++;
            }
        }
        return answer;
    }
}