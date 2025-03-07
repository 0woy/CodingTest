import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N_1920 {
    /** First Try: minus value..
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[]arr = new boolean[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            arr[Integer.parseInt(st.nextToken())]=true;
        }
        n = Integer.parseInt(br.readLine());
        int [] res = new int[n];
        st = new StringTokenizer(br.readLine());
        int idx =0;
        while(st.hasMoreTokens()){
            int cur = Integer.parseInt(st.nextToken());
            if(arr[cur]){
                res[idx]=1;
            }else{
                res[idx]=0;
            }
            idx++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int v: res){
            bw.write(v+"\n");
        }
        bw.flush();
        bw.close();


    }*/
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> tree =new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            tree.add(Integer.parseInt(st.nextToken()));
        }
        n = Integer.parseInt(br.readLine());
        byte [] res = new byte[n];
        st = new StringTokenizer(br.readLine());
        int i =0;
        while(st.hasMoreTokens()){
            int cur = Integer.parseInt(st.nextToken());
            if(tree.contains(cur)){
                res[i++] = 1;
            }else{
                res[i++]=0;
            }
        }
        for(byte c: res){
            bw.write(c+"\n");
        }
        bw.flush();
        bw.close();

    }
}
