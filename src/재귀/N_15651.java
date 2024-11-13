import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_15651 {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n];
        backtracking(n,m,0);
        System.out.println(sb.toString());
    }
    public static void backtracking(int n, int m, int depth){
        if(depth==m){
          for(int v: arr){
                sb.append(v+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++){
            arr[depth] = i;
            backtracking(n,m,depth+1);
        }
    }
}
