package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N_1240 {
    static Map<String, Integer> decode;
    public static void setDecode(){
        decode = new HashMap<>();
        decode.put("0001101",0);
        decode.put("0011001",1);
        decode.put("0010011",2);
        decode.put("0111101",3);
        decode.put("0100011",4);
        decode.put("0110001",5);
        decode.put("0101111",6);
        decode.put("0111011",7);
        decode.put("0110111",8);
        decode.put("0001011",9);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        setDecode();
        int tc =Integer.parseInt(br.readLine());

        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            StringBuilder r = new StringBuilder();
            while(row -- >0){
                r.append(br.readLine());
                int lastIdx = r.lastIndexOf("1");
                if(lastIdx!=-1){
                    String encode= r.substring(lastIdx-55,lastIdx+1);
                    int res = calc(encode);
                    sb.append(res+"\n");
                    break;
                }
                r.setLength(0);
            }
            while(row-- >0){
                br.readLine();
            }
        }

        System.out.println(sb.toString());
    }
    public static int calc(String encode){
        int mul =0;
        int plus =0;
        boolean isOdd = true;
        for(int i=0;i<encode.length();i+=7){
            int cur = decode.get(encode.substring(i,i+7));
            if(isOdd){
                mul +=cur;
            }
            else{
                plus+=cur;
            }
            isOdd =!isOdd;
        }
        int total =(mul*3)+plus;
        if(total%10==0){
            return mul+plus;
        }else{
            return 0;
        }
    }
}
