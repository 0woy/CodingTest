import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = new String[3];
        int next =0;
        for(int i=0;i<3;i++) {
            String cur = br.readLine();
            str[i] = cur;
            if(str[i].replaceAll("[0-9]","").equals("")){
                next = Integer.parseInt(str[i]) + 3-i;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(next % 15==0){
            sb.append("FizzBuzz");
        }
        else if(next %3==0){
            sb.append("Fizz");
        }
        else if(next % 5 ==0){
            sb.append("Buzz");
        }
        else{
            sb.append(next);
        }
        System.out.println(sb.toString());

    }
}
