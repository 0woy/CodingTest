package Data_Structure;

import java.io.*;
import java.util.*;

public class N_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(Collections.reverseOrder());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();
            if(log.equals("enter")){
                set.add(name);
            }else{
                set.remove(name);
            }
        }
        for(String v: set){
            bw.write(v+"\n");
        }
        /** List 사용
        List<String> list=  new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
         
        for(String v: list){
            bw.write(v+"\n");
        }
         */
        bw.flush();
        bw.close();

    }
}
