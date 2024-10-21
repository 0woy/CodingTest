package Data_Structure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        bw.write("<");
        int n= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int cur =0;
        while(list.size()>1){
            cur = (cur+k-1)%list.size();
            bw.write(list.remove(cur)+", ");
        }
        bw.write(list.remove(0)+">");

        bw.flush();
        bw.close();

    }
}
