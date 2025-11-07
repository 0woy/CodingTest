// n=3, wrong:9, 9/n = 0 (마지막 사람, 3번째(몫))
// n=2, wrogn: 5, 5/2 =2, 1 (21번째 사람)

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char prev = words[0].charAt(words[0].length()-1);
        
        for(int i=1;i<words.length;i++){
            if(set.contains(words[i])||prev!=words[i].charAt(0)){
                return new int[]{i%n+1, i/n+1};
            }
            set.add(words[i]);
            prev = words[i].charAt(words[i].length()-1);
        }

        return new int[]{0,0};
    }
}