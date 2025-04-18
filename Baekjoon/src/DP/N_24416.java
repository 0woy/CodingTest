package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_24416 {
    static int [] count;
    public static int recur(int n){
        if(n==1 || n==2){
            count[0]++;
            return 1;
        }else{
            return recur(n-1)+recur(n-2);
        }
    }

    public static int dp(int n){
        int [] arr =new int[n+2];
        arr[1]=arr[2]=1;

        for(int i=3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
            count[1]++;
        }
        return arr[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        count = new int[2];
        recur(n);
        dp(n);
        System.out.println(count[0]+" "+count[1]);
    }

}
