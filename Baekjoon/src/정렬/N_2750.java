import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class N_2750 {
    /** Previous Solve
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i + "\n");

        System.out.print(sb);
    }
     */
    /** Priority Queue
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(n-- > 0){
            pq.add(Integer.parseInt(br.readLine()));
        }
        while(!pq.isEmpty()){
            bw.write(pq.poll()+"\n");
        }
        bw.flush();
        bw.close();
    }
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [] arr= new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int v: arr){
            bw.write(v+"\n");
        }
        bw.flush();
        bw.close();
    }
}
