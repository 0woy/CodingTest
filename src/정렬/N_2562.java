import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class N_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        Integer [] arr =new Integer[9];
        Integer [] tmp =new Integer[9];

        for(int i=0;i<9;i++){
            int cur = Integer.parseInt(br.readLine());
            arr[i] = cur;
            tmp[i] = cur;
        }

        Arrays.sort(tmp, Collections.reverseOrder());

        int max = tmp[0];
        sb.append(max+"\n");

        int idx =1;
        for(int v: arr){
            if(v == max){
                sb.append(idx);
                System.out.println(sb);
                return;
            }
            idx++;
        }
    }
}
