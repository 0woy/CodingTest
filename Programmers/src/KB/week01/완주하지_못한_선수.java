package KB.week01;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            if (!map.containsKey(c)) {
                return c;
            }
            int res = map.get(c) - 1;
            if (res == 0) {
                map.remove(c);
            } else {
                map.put(c, res);
            }
        }
        for (String key : map.keySet()) {
            return key;
        }
        return "";
    }
}
