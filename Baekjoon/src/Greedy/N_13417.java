package Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class N_13417 {
    /** My Solve
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc =Integer.parseInt(br.readLine());

        while (tc -- >0){
            br.readLine();
            StringBuilder str = new StringBuilder();
            int front= 27;
            int idx =0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                char cur =st.nextToken().charAt(0);
                if(cur-'A' <= front){
                    str.insert(0,cur);
                    front = cur-'A';
                }else{
                    str.append(cur);
                }

            }
            sb.append(str+"\n");
        }
        System.out.println(sb.toString());
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int tc =Integer.parseInt(br.readLine());

        while (tc -- >0) {
            br.readLine();
            StringBuilder res= new StringBuilder();
            String str = br.readLine();
            char front =str.charAt(0);
            res.append(front);

            for(int i=2;i<str.length();i+=2){
                char cur = str.charAt(i);
                if(cur <= front){
                    res.insert(0, cur);
                    front=cur;
                }else{
                    res.append(cur);
                }
            }
            bw.write(res+"\n");
        }
        bw.flush();
        bw.close();
    }
}
