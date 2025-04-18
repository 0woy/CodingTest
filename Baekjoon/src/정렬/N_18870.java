import java.io.*;
import java.util.*;

public class N_18870 {
    /** Map, Priority Queue, Array : memeory 341416kb, time	2344ms
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        while(st.hasMoreTokens()){
            int val = Integer.parseInt(st.nextToken());
            pq.add(val);
            arr[i++]=val;
        }

        int count = 0;
        while(!pq.isEmpty()){
            int prev = pq.poll();
            map.put(prev, count);
            if(!pq.isEmpty() && prev!=pq.peek()){
                count++;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int key: arr){
            bw.write(map.get(key)+" ");
        }
        bw.flush();
        bw.close();
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int [] arr  =new int[n];
        int [] sorted  =new int[n];

        for(int i=0;i<n;i++){
            int v =  Integer.parseInt(st.nextToken());
            arr[i] =v;
            sorted[i] =v;
        }
        Arrays.sort(sorted);
        int count =0;
        for(int v: sorted){
            if(map.containsKey(v)){
                continue;
            }
            map.put(v, count++);
        }

        for(int v: arr){
            bw.write(map.get(v)+" ");
        }
        bw.flush();
        bw.close();
    }
}
