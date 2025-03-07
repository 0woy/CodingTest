package Data_Structure;

import java.io.*;
import java.util.*;

public class N_2776 {
    /** Do not consider negative value
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc =Integer.parseInt(br.readLine());

        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            boolean [] ans = new boolean[1000001];
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                ans[Integer.parseInt(st.nextToken())] = true;
            }
            br.readLine();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                int find = Integer.parseInt(st.nextToken());
                if(find >= ans.length){continue;}
                if(ans[find]){
                    bw.write(1+"\n");
                }else{
                    bw.write(0+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc =Integer.parseInt(br.readLine());

        while(tc-- > 0){
            Set<Integer> ans = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                ans.add(Integer.parseInt(st.nextToken()));
            }

            br.readLine();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                int find = Integer.parseInt(st.nextToken());
                if(ans.contains(find)){
                    bw.write("1\n");
                }else{
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
