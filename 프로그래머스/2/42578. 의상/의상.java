import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth: clothes){
            String key = cloth[1];
            map.put(cloth[1], map.getOrDefault(cloth[1],1)+1);
        }
        int answer = 1;
        for(int v: map.values()){
            answer*=v;
        }
        return answer-1;
    }
}

/**
종류별로 한 개씩만 입을 수 있음,
하루에 하나만 입어도 됨.
종류: a, b, c, 0
종류: d, e, 0

*/