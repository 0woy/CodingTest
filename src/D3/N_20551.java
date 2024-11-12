package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_20551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");
            st = new StringTokenizer(br.readLine());
            int [] box = new int[3];
            for(int i=0;i<3;i++){
                box[i] = Integer.parseInt(st.nextToken());
            }
            int max = box[2];
            int total= 0;
            for(int i=1;i>=0;i--){
                if(max ==1){total =-1;}
                if(box[i]>=max){
                    int eat = box[i]-max+1;
                    if(eat > box[i] || box[i]==0 || total==-1){
                        total=-1;
                        break;
                    }
                    total+=eat;
                    box[i] = box[i]-eat;
                }
                max  = box[i];
            }
            sb.append(total+"\n");
        }
        System.out.println(sb.toString());
    }
}
