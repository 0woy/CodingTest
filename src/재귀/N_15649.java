import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_15649 {
    /** Not myself
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        arr = new int[n];

        backtracking(n,len,0);
        System.out.print(sb.toString());
    }
    public static void backtracking(int n,int m, int depth){
        if(depth == m){
            for(int i=0;i<m;i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            return;
        }
        for(int i = 1;i<=n;i++){
            if(!visited[i]){
                visited[i]= true;
                arr[depth] = i;
                backtracking(n,m,depth+1);
                visited[i]=false;
            }
        }
    }*/

    static boolean [] visited;
    static int [] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        sb= new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        arr = new int[n+1];

        backtracking(n,m,0);
        System.out.print(sb.toString());
    }

    public static void backtracking(int n, int m, int depth){
        if(depth == m){
            for(int i=0;i<depth;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backtracking(n,m,depth+1);
                visited[i]=false;
            }
        }
    }

}
