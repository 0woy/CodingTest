import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_8958 {
    public static int calc(String str){
        int cur =0;
        int total = 0;
        for(char ch: str.toCharArray()){
            if(ch == 'O'){
                cur++;
                total+=cur;
            }
            else{
                cur = 0;
            }
        }
        return total;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(testcase >0){
            String str = br.readLine();
            sb.append(calc(str)+"\n");
            testcase--;
        }
        System.out.println(sb.toString());
    }
}
