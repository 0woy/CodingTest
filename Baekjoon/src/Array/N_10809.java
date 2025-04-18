import java.io.*;

public class N_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char cur = 'a';

        for(int i=0;i<26;i++){
            bw.write(str.indexOf(cur)+" ");
            cur++;
        }
        bw.flush();
        bw.close();
    }
}
