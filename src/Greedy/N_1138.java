package Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [] input = new int[n];
        List<Integer> res = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            input[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            int max = input[n-i-1]; // 현재 가장 큰 수의 앞에 있는 친구들
            if(max == 0) { // 나보다 큰 애 없음
                res.add(0, n - i);
                continue;
            }
            res.add(max, n-i);
        }

        for(int v: res){
            bw.write(v+" ");
        }
        bw.flush();
        bw.close();

    }
}
