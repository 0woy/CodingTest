package Greedy;

import javax.swing.border.EtchedBorder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1931 {
    /** 바보 접근
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
                new Comparator<Integer[]>() {
                    @Override
                    public int compare(Integer[] o1, Integer[] o2) {
                        if(o1[1]==o2[1]){
                            return o1[0]-o2[0];
                        }
                        return o1[1]-o2[1];
                    }
                }
        );

        while(n -- >0){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Integer[]{s,e});
            PriorityQueue<Integer> tmp = map.getOrDefault(s, new PriorityQueue<>());
            tmp.add(e);
            map.put(s, tmp);
        }
        while(!pq.isEmpty()){
            Integer[] tmp = pq.poll();
            System.out.println(tmp[0]+" "+tmp[1]);
        }
        System.out.println(map.toString());
        int count =0;

        List<Integer> keys= map.keySet().stream().toList();
        Collections.sort(keys);
        while(true){
            Integer[] v = pq.poll();
            int end = v[1];
            for(int key: keys){
                if(key>=end){
                }
            }
        }
    }
     */
    /** Wrong
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> start = new ArrayList<>();
        List<int[]> end = new ArrayList<>();

        while( n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            start.add(new int[]{s,e});
            end.add(new int[]{s,e});
        }

        Collections.sort(start, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        Collections.sort(end, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int sTime =end.get(0)[1];
        int eTime = start.get(start.size()-1)[0];
        int count =0;
        int idx  = 0;

        while(sTime <= eTime){
            while(sTime>start.get(idx)[0]){
                idx++;
            }
            sTime = start.get(idx++)[1];
            count++;
        }
        System.out.println(count);

    }
 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });

        int count =0;
        int prev_end_time =0;
        for(int i=0;i<n;i++){
            if(prev_end_time <= time[i][0]){
                prev_end_time = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
