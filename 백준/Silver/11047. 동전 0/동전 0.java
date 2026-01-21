import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int [] money = new int[n];
        for(int i=money.length-1;i>=0;i--){
            money[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        while(k>0){
            int idx = 0;
            int div = money[idx];
            while(k/div==0 && idx  < money.length){
                div = money[idx++];
            }
            answer+=k/div;
            k%=div;
        }
        System.out.println(answer);
    }
}
