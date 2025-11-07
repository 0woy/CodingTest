import java.util.*;
// 도착지: n
// 최소의 건전지로 도착하는 방법
// 0 1 2 3 4 5 6 7 8
//   1 0 1 0 1 1   0
// 2의 n승 = 1로 유지 가능
// 2의 n승*3 = 2로 유지 가능
// 
// 순간이동 하기 vs 1칸 이동하기 중 가장 적은 값을 취하기
// 0 1 2 3 4 5 6
//   1
// 2:  Math.min (dp[i-1]+1, dp[i]/2 ) 딱 떨어져야댐 (i%2==0 -> 비교)
public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n!=0){        
            if(n%2!=0){
                n-=1; ans++;
            }
            n/=2;
        }
        return ans;
    }
}