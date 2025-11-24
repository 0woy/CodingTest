import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(String op : operations){
            String[] info = op.split(" ");            
            int key = Integer.parseInt(info[1]);            
            if(info[0].equals("I")){
                map.put(key, map.getOrDefault(key, 0)+1);                
            }else{
                int count =0;
                if(map.isEmpty()) continue;
                // 최솟값 삭제
                key = (key==1)?map.lastKey():map.firstKey();
                count = map.get(key);
                if(count <= 1 )map.remove(key);
                else  map.put(key, count-1);                
            }
        }
        if(map.isEmpty()) return new int[]{0,0};
        return new int[]{map.lastKey(), map.firstKey()};
    }
}