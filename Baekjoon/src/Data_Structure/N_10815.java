package Data_Structure;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        while(st.hasMoreTokens()){
            set.add(Integer.parseInt(st.nextToken()));
        }
        br.readLine();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if(set.contains(Integer.parseInt(st.nextToken()))){
                bw.write(1+" ");
            }else{
                bw.write(0+" ");
            }
        }
        bw.flush();
        bw.close();

    }
}
