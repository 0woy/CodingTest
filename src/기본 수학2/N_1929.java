import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class N_1929 {
    /** Previous Solve
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        prime = new boolean[end + 1];
        get_prime();

        for (int i = start; i <= end; i++) {
            if (prime[i] == false) {
                System.out.println(i);
            }
        }

    }

    // 에라토스테네스의 체
    static void get_prime() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        if(m==1){m++;}
        for(int i=m;i<=n;i++){
            boolean p = true;
            for(int k=2;k<=Math.sqrt(i);k++){
                if(i%k==0){
                    p = false;
                    break;
                }
            }
            if(p){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
