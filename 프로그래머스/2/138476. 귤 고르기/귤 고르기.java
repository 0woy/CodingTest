import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map =new HashMap<>();
        for(int v : tangerine){
            map.put(v, map.getOrDefault(v,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<>((o1, o2) ->{
                if(o2.getValue()==o1.getValue()){
                    return o1.getKey()-o2.getKey();
                }
                return Integer.compare(o2.getValue(),o1.getValue());
            });
        pq.addAll(map.entrySet());
        int count = 0;
        while(k>0){
            k -= pq.poll().getValue();
            count++;
        }
        return count;
    }
}