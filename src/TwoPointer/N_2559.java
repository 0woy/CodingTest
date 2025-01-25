package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] temp = new int[n];
        st =new StringTokenizer(br.readLine());
        int idx =0;
        while(st.hasMoreTokens()){
            temp[idx++] = Integer.parseInt(st.nextToken());
        }
        int front= 0, end = k;
        long max =0;

        for(int i=0;i<k;i++){
            max +=temp[i];
        }

        long prev = max;
        while (end<temp.length){
            prev = prev-temp[front++]+temp[end++];
            max = Math.max(max, prev);
        }
        System.out.println(max);

    }
}
