import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strs= Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        
        Arrays.sort(strs, (a,b)-> (b+a).compareTo(a+b));
        if(strs[0].equals("0")) return "0"; // 0만 여러개면 "000" → "0"

        StringBuilder sb = new StringBuilder();
        for(String s : strs) sb.append(s);
        return sb.toString();
    }
}