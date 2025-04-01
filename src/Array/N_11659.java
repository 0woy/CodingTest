package Array;

import java.io.*;
import java.util.StringTokenizer;

public class N_11659 {
    /** Previous Solve
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());
        int [] arr =new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<arr.length;i++){
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }
        while(tc-- >0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write((arr[end]-arr[start-1])+"\n");
        }
        bw.flush();
        bw.close();
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());
        int [] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        arr[0] = 0;

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken())+arr[i-1];
        }

        while (tc-- > 0){
            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write((arr[e]-arr[s-1])+"\n");
        }

        bw.flush();
        bw.close();

    }
}
