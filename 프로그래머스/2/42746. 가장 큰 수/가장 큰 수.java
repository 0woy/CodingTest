import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String [] nums = new String[numbers.length];        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numbers.length;i++){
            nums[i] =String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (a,b)->{
            return (b+a).compareTo(a+b);
        });
        for(String str: nums){
            sb.append(str);
        }
        if(sb.charAt(0)=='0') return "0";
        return sb.toString();
    }
}
/**
0또는 양의 정수,
정수를 이어 붙여 만들 수 있는 가장 큰 수
3 30 34 5 9 
34 > 3 > 32

문자로 봐야하려나?
Map<Integer, List<String>> map
정렬할 때는,,, List<String> tmp = map.values()
Collections.sort(길이가 다르면, )
345
343
3
321
300

*/