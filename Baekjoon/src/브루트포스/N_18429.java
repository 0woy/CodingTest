import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_18429 {
    static int [] arr;
    static boolean [] visited;
    static int minus;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in ));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited =new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        total = 0;
        backtracking(n,1,500);
        System.out.println(total);
    }

    public static void backtracking(int m, int depth, int kg){
        if(m==depth){
            total++;
            return;
        }
        if(kg < 500){
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                backtracking(m, depth+1,kg+arr[i]-minus);

                visited[i]=false;
            }
        }
    }
}
