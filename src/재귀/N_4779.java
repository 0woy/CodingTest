import java.io.*;

public class N_4779 {
    static StringBuilder str;
    public static void recur(int start, int end, int len){
        if(len == 1){
            return;
        }
        int div = len/3;
        str.replace(start+div, end-div+1, " ".repeat(div));
        recur(start, start+div-1, div);
        recur(start+(div*2), start+len-1, div);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num =br.readLine();
        while(num!=null){
            int len = (int) Math.pow(3, Integer.parseInt(num));

            str = new StringBuilder("-".repeat((int) len));
            recur(0,len-1,len);

            bw.write(str.toString()+"\n");
            num = br.readLine();
        }
        bw.flush();

    }
}
