import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String name: participant){
            map.put(name, map.getOrDefault(name, 0)+1);
        }
        
        for(String goal: completion){
            map.put(goal, map.get(goal)-1);
            if(map.get(goal)==0) map.remove(goal);
        }
        List<String> list = new ArrayList<>(map.keySet());
        return list.get(0);
    }
}

/**
한 명 제외 마라톤 완주
선수 이름 배열 p
완주 선수 이름 배열 c

미완주 선수 return 

p.len = 10만 (nLogn)
동명이인 ok = set 사용 불가
Map <이름, 사람 수>, -> 
1. p 돌면서 map 초기화
2. c 돌면서 map value 감소 (0이 되면 제거)
3. 마지막에 남은 key (사람) 반환 
*/
