import java.io.*;
import java.util.StringTokenizer;

public class N_6064 {
    /** WWWWWWWWWWWWWWRONG
     public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     StringTokenizer st;

     int tc = Integer.parseInt(br.readLine());
     while (tc -- > 0) {
     st = new StringTokenizer(br.readLine());
     int n = Integer.parseInt(st.nextToken());
     int m = Integer.parseInt(st.nextToken());

     int x = Integer.parseInt(st.nextToken());
     int y = Integer.parseInt(st.nextToken());

     int val = Math.abs(n - m);


     // always odd
     if ((n % 2 == 0 && m % 2 != 0) || (n % 2 != 0 && m % 2 == 0)) {

     }
     else {
     int diff =Math.abs(x-y);
     if(diff%2!=0){
     bw.write(-1+"\n");
     continue;
     }
     else{
     int cycle = diff/val;
     if(n<m){
     // y기준 cycle
     if(x>y){

     }

     }else{


     }

     }
     }
     }

     }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int lcm = (M*N)/gcd(N,M);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int k = x;
            while (k<=lcm){
                if(k%N == y%N){
                    bw.write(k+"\n");
                    break;
                }
                k+=M;
            }
            if(k>lcm){
                bw.write(-1+"\n");
            }
        }
        bw.flush();
        bw.close();


    }
    public static int gcd(int m, int n){
        if(n==0){return m;}
        return gcd(n, m%n);

    }
}
