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
        
        for(int i=0;i<t;i++){
            res.append(sb.charAt(p-1+i*m));
        }
        
        return res.toString().toUpperCase();
    }
}