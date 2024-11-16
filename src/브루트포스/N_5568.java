import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class N_5568 {
    static String [] str;
    static Set<String> res;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        str = new String[n];
        visited = new boolean[n];
        res = new HashSet<>();
        for(int i=0;i<n;i++){
            str[i] = br.readLine();
        }
        dfs(n,k,0,new StringBuilder());
        System.out.println(res.size());

    }
    public static void dfs(int n, int m, int depth, StringBuilder sb){
        if(m==depth){
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(n, m,depth+1,sb.append(str[i]));
                sb.delete(sb.lastIndexOf(str[i]), sb.length());
                visited[i]=false;
            }
        }
    }
}
