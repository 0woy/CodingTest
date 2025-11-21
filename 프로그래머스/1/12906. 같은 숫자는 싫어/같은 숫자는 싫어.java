import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int prev =10;
        List<Integer> list = new ArrayList<>();
        for(int v: arr){
            if(prev != v){
                 list.add(v);
                prev =v;
            }
            
        }        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}