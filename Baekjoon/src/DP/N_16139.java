package DP;

import java.io.*;
import java.util.StringTokenizer;

public class N_16139 {
    /** HashMap: 메모리 & 접근 속도 저하
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();
        Map<Integer, int[]> map = new HashMap<>();
        int tc = Integer.parseInt(br.readLine());

        for(int i=0;i<str.length();i++){
            int pos = str.charAt(i)-'a';
            int [] alpha = (i==0)
                    ?new int[26]
                    : map.get(i-1).clone();
                    // :Arrays.copyOf(map.get(i-1), 26);

            alpha[pos]++;
            map.put(i, alpha);
        }

        while(tc-- >0){
            st=new StringTokenizer(br.readLine());
            int pos =st.nextToken().charAt(0)-'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int count = 0;
            if(start ==0){
                count = map.get(end)[pos];
            }else{
                count = map.get(end)[pos]-map.get(start-1)[pos];
            }

            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();

    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();
        int [][] dp = new int[26][str.length()];

        int tc = Integer.parseInt(br.readLine());

        for(int i=0;i<str.length();i++){
            int pos = str.charAt(i)-'a';
           if(i>0){
               for(int j=0;j<26;j++){
                   dp[j][i] = dp[j][i-1];
               }
           }
           dp[pos][i]++;
        }

        while(tc-- >0){
            st=new StringTokenizer(br.readLine());
            int pos =st.nextToken().charAt(0)-'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int count = 0;
            if(start ==0){
                count = dp[pos][end];
            }else{
                count = dp[pos][end] - dp[pos][start-1];
            }

            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();

    }
}
