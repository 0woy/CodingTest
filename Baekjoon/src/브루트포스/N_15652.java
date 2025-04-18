import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_15652 {
    static int [] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        arr = new int[m];

        backtracking(0, n,m,0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int start, int n,int m, int depth){
        if(depth==m){
            for(int v: arr){
                sb.append(v+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<n;i++){
                arr[depth] = i+1;
                backtracking(i, n, m, depth+1);
        }
    }
}
