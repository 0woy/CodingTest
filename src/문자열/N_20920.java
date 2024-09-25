import java.io.*;
import java.util.*;

public class N_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int slen = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String cur = br.readLine();
            if(cur.length()<slen){
                continue;
            }

            map.put(cur, map.getOrDefault(cur, 0)+1);

        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue()!=o2.getValue())
                    return o2.getValue().compareTo(o1.getValue());
                if(o1.getKey().length()!= o2.getKey().length()){
                    return o2.getKey().length()-o1.getKey().length();
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(Map.Entry<String, Integer> entry: list){
            bw.write(entry.getKey()+"\n");
        }
        bw.flush();
    }
}
