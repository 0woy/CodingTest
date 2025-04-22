package String;

import java.util.ArrayList;
import java.util.*;

public class _3진법_뒤집기 {
    class Solution {
        public int solution(int n) {
            String str = Integer.toString(n,3);
            int len = str.length();
            List<Character>list = new ArrayList<>();
            for(int i=0;i<len;i++)
                list.add(str.charAt(i));
            Collections.reverse(list);

            String tmp ="";
            for(int i=0;i<list.size();i++){
                tmp+=list.get(i);
            }
            return Integer.parseInt(tmp,3);
        }
    }
}
