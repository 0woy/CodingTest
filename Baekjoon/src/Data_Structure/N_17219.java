package Data_Structure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        while(n>0){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
            n--;
        }
        while(question > 0){
            bw.write(map.get(br.readLine())+"\n");
            question--;
        }
        bw.flush();
        bw.close();
    }
}
