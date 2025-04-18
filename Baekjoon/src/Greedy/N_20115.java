package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());

        int max = 0;
        float total = 0;
        for(int i=0;i<n;i++){
            int cur = Integer.parseInt(st.nextToken());

            if(max < cur){ max =cur;}
            total+=cur;
        }

        System.out.println(max+(total-max)/2.0);
    }
}
