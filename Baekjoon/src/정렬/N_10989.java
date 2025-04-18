import java.io.*;
import java.util.*;

public class N_10989 {
    /** First Try: Memory Exceed
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            que.add(Integer.parseInt(br.readLine()));
        }
        for(int val:que){
            System.out.println(val);
        }

    }
     */

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] =Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int val: arr){
            bw.write(val+"\n");
        }
        bw.flush();
        bw.close();
    }
}
