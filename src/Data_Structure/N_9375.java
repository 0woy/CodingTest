package Data_Structure;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class N_9375 {
    /** First Try
    static BufferedReader br;
    static Map<String, ArrayList<String>> map;
    public static void initMap(int n) throws IOException {
        StringTokenizer st;
        while(n > 0){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String sort = st.nextToken();
            ArrayList<String> val =map.getOrDefault(sort, new ArrayList<>());
            val.add(name);
            map.put(sort, val);
            n--;
        }
    }
    public static int calc(int max, List<String>key, int start, int total){
        if(max==0){
            return total+1;
        }
        for(String v: map.get(key.get(start))){
            total = calc(max-1, key, start+1, total);
        }
        return total;
    }
    public static void main(String[] args) throws IOException {
        br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while(tc>0){
            int n = Integer.parseInt(br.readLine());
            int total=0;
            map = new HashMap<>();
            initMap(n);
            List<String> key = new ArrayList<>(map.keySet());
            total += n;
            for(int max=2;max<=key.size();max++){
               total = calc(max, key,0,total);
            }
            bw.write(total+"\n");
            tc--;
        }
        bw.flush();
        bw.close();
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        while(tc-- >0){
            Map<String, Integer> map = new HashMap<>();
            int count  = Integer.parseInt(br.readLine());
            while(count -- >0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String sort = st.nextToken();
                map.put(sort, map.getOrDefault(sort,1)+1);
            }
            long result = 1;
            for(String key: map.keySet()){
                result*=map.get(key);
            }
            result-=1;
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
}
