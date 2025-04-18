package Array;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N_10986 {
    /** Wrong
    public static <Set> void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        long total =0;
        int count =0;
        HashSet<Long> sum  = new HashSet<>();
        for(int i =0; i<n; i++){
            int cur =Integer.parseInt(st.nextToken());
            if(cur%m ==0) {
                count++;
            }
            arr[i]=cur;
            total+=cur;
            if(total%m==0){
                count++;
                for(int k=m;k<=total-m;k+=m){
                    if(sum.contains(k)){
                        count++;
                    }
                }
            }else{
                if(sum.contains(total%m)) {
                    count++;
                }
            }
            sum.add(total);
        }
        System.out.println(count);

    }
     */
    public static <Set> void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] remain = new int[m];
        st = new StringTokenizer(br.readLine());
        long prev =0;
        for(int i = 0; i < n; i++) {
            int cur =Integer.parseInt(st.nextToken());
            remain[(int) ((prev + cur)%m)]++;
            prev +=cur;
        }
        long count = remain[0];
        for(int i = 0; i < m; i++) {
            count+= (long) remain[i] *(remain[i]-1) / 2;
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}
