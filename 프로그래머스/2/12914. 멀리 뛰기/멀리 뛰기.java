import java.util.*;
class Solution {
    public long solution(int n) {
        long [] step = new long[n+1];
        step[0]=1;
        step[1]=1;        
            
        for(int i=2;i<=n;i++){
            step[i] = (step[i-1]+step[i-2]) % 1234567;            
        }
        return step[n] % 1234567;
    }
}