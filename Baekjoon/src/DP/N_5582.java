package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int n= s1.length(), m=s2.length();

        int max = 0;
        int [][] str = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    str[i][j] = str[i-1][j-1] + 1;
                    if(max<str[i][j]){
                        max = str[i][j];
                    }
                }
            }
        }
        System.out.println(max);
    }
}
