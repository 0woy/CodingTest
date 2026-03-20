import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        return Math.min(map.size(),nums.length/2);
    }
}

/**
N마리 중 N/2 마리 
종류에 따라 번호를 붙여 구분, (물속성은 = 같은 번호)
최대한 다양한 종류의 포켓몬을 조합해 N/2 선택
중복되는 숫자 주어진 배열, 선택한 숫자 개수 return

nums.len = 1만
nums = 20만 종류
nums.len/2

map <number, 해당 숫자 개수>
1. map의 길이가 nums.len/2보다 큰 경우 -> n/2 return
2. map의 길이가 nums.len/2보다 적은 경우 (중복이 많음)
-> 
if) n=6, 선택 =3
map.len >= n/2 : return map.len
3:1 
2:1
4:1
if) n=6, 선택 =3
3:2
2:1
map.len < n/2 = return map.len


if) n=4, 선택 =2
1:1
2:1
3:2
map.len = 2
*/