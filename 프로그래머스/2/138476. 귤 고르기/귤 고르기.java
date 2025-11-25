import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map =new HashMap<>();
        for(int v : tangerine){
            map.put(v, map.getOrDefault(v,0)+1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, (a,b) ->{
            return Integer.compare(b,a);
        });
        int count = 0;
        while(k>0){
            k-= list.remove(0);
            count++;
        }
        return count;
    }
}