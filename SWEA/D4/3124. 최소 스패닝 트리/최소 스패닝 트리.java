import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    static PriorityQueue<int[]> pq;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc =Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");
            String [] info = br.readLine().split(" ");
            pq = new PriorityQueue<>((a, b) -> {
                return Integer.compare(a[2], b[2]);
            });
            map = new HashMap<>();
            int n = Integer.parseInt(info[0]);
            int e = Integer.parseInt(info[1]);

            for(int i=0;i<e;i++){
                String [] cur = br.readLine().split(" ");
                int a = Integer.parseInt(cur[0]);
                int b = Integer.parseInt(cur[1]);
                int w = Integer.parseInt(cur[2]);
                pq.offer(new int[]{a,b,w});
                map.putIfAbsent(a, a);  // root
                map.putIfAbsent(b, b);
            }
            int i =0;
            long total =0;
            while(i < n-1){
                int [] cur = pq.poll();
                if(union(cur[0],cur[1])){
                    total += cur[2];
                    i++;
                }
            }
            sb.append(total+"\n");
        }
        System.out.println(sb);
    }
    static boolean union(int a, int b){
        int a_root = find(a);
        int b_root = find(b);
        if(a_root != b_root){
            map.put(b_root, a_root);
            return true;
        }
        return false;
    }
    static int find(int a){
        if(map.get(a)!=a){
            map.put(a, find(map.get(a)));
        }
        return map.get(a);
    }
}
