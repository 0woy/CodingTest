import java.util.*;

public class Solution {
    public int solution(int n) {
        int k=1;
        while(n>1){
            if(n%2==1){k++; n-=1;}
            n/=2;
        }

        return k;
    }
}