import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_15650 {
    static boolean [] visited;
    static int [] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        sb= new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arr = new int[n];

        backtracking(0,n,m,0);
        System.out.print(sb.toString());


    }

    public static void backtracking(int cur,int n, int m, int depth){
        if(depth==m){
            for(int i=0;i<depth;i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
        }

        for(int i=cur;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                arr[depth] = i+1;
                backtracking(i+1, n,m,depth+1);
                visited[i]=false;
            }
        }
    }
}
