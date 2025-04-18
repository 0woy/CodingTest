package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10974 {
    static StringBuilder sb;
    static boolean[] vistited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        vistited=new boolean[n+1];

        recur(new int[n],0);
        System.out.println(sb.toString());
    }
    public static void recur(int[]arr, int idx){
        if(idx==arr.length){
            for(int v: arr){
                sb.append(v+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=arr.length;i++){
            if (!vistited[i]){
                vistited[i]=true;
                arr[idx]=i;
                recur(arr,idx+1);
                vistited[i]=false;
            }
        }
    }
}
