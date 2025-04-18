import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1182 {
    static int [] arr;
    static boolean [] visited;
    static int goal;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        arr =new int[n];
        visited = new boolean[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        total = 0;
        for(int i=1;i<=n;i++){
            dfs(i,0,0,0);
        }
        System.out.println(total);
    }

    public static void dfs(int n,int depth,long cur, int start ){
        if(cur == goal && depth==n){
            total++;
        }
        if(n==depth){
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(n,depth+1,cur+arr[i],i+1);
                visited[i]=false;
            }
        }
    }
}
