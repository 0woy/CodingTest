package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> a = new HashSet<>();

        br.readLine();
        StringTokenizer st =new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int cur =Integer.parseInt(st.nextToken());
            if(a.contains(cur)){
                a.remove(cur);
            }else{
                a.add(cur);
            }
        }

        System.out.println(a.size());

    }
}
