import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Long> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n>1022){
            System.out.println(-1);
            return;
        }
        arr = new ArrayList<>();
        for(int i=0;i<=9;i++){
            recur(i, i);
        }
        Collections.sort(arr);
        System.out.println(arr.get(n));
    }
    static void recur(long num, int lastDigit){
        arr.add(num);
        for(int i =0;i<lastDigit;i++){
            recur(num*10+i, i);
        }
    }
}
