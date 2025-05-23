package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int [][] str = new int[s1.length()+1][s2.length()+1];
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    str[i][j] = str[i-1][j-1] + 1;
                }
                else{
                    str[i][j] = Math.max(str[i-1][j], str[i][j-1]);
                }
            }
        }
        System.out.println(str[s1.length()][s2.length()]);
    }
}
