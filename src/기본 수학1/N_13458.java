import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] student = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            student[i]= Integer.parseInt(st.nextToken());
        }
        st =new StringTokenizer(br.readLine());
        int admin = Integer.parseInt(st.nextToken());
        int semi = Integer.parseInt(st.nextToken());

        long total = 0;
        for(int v:student){
            v -= admin;
            total++;
            if(v>0){
                total += v/semi;
                if(v%semi!=0){
                    total++;
                }
            }
        }
        System.out.println(total);

    }
}
