import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int count =0;
        int hear = Integer.parseInt(st.nextToken());
        int see = Integer.parseInt(st.nextToken());
        Map<String, Boolean> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i=0;i<hear;i++){
            map.put(br.readLine(), false);
        }
        for(int i=0;i<see;i++){
            String cur =br.readLine();
            if(map.containsKey(cur)){
                count++;
                res.add(cur);
            }
        }
        Collections.sort(res);
        sb.append(count+"\n");
        for(String v: res){
            sb.append(v+"\n");
        }
        System.out.println(sb.toString());

    }
}
