import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        sb.append(0).append(1);
        int len = m*t;
        for(int num=2;sb.length()<len;num++){
            sb.append(Integer.toString(num,n));
        }
        
        int idx = p-1;
        while(t>0){
            res.append(sb.charAt(idx));
            t--;
            idx+=m;
        }
        
        return res.toString().toUpperCase();
    }
}

/**
2진법, 2명, 1번, 4개
0, 1, 10, 11, 100, 101, 110, 111

m*t= 2*4 = 8개 p=1;

m=3, t=4, p=1 len =4*3=12
0, 1, 10, 11, 100, 101, 110, 111
1 2   31  23  123  123  123  123

p=1: 0, 3, 6, 9
p=2: 1, 4, 7, 10
p=3: 2, 5, 8, 11 

-> startIdx = p-1 + m(m=0~<t)

len = 8을 0, 2, 4, 6 / 1 3 5 7


*///3진법

