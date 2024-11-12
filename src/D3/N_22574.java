package D3;

import java.io.*;
import java.util.StringTokenizer;

public class N_22574 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while(tc -- > 0){
            long start = 0;
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int bomb = Integer.parseInt(st.nextToken());
            for(int up=1;up<=count;up++){
                start+=up;
                if(start==bomb){
                  start--;
                }
            }
            bw.write(start+"\n");
        }
        bw.flush();
        bw.close();
    }
}
