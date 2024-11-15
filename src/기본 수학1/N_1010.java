import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc -- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(combination(n,m)+"\n");
        }
        System.out.println(sb.toString());
    }
    public static long combination(int n, int m){
        if(n > m-n){
            n = m-n;
        }
        long res =1;
        for(int i=0;i<n;i++){
            res *=(m-i);
            res /= (i+1);
        }
        return res;
    }
    /**
    public static void dfs(int n, int m, int start, int depth){
        if(depth == n){
            count++;
            return;
        }
        for(int i=start;i<m;i++){
            dfs(n, m, i+1,depth+1);
        }
    }
     */
}
