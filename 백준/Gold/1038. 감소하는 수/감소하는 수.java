import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static long[] arr;
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n>1022){
            System.out.println(-1);
            return;
        }
        idx = 0;
        arr = new long[1023];
        for(int i=0;i<=9;i++){
            recur(i, i);
        }
        Arrays.sort(arr);
        System.out.println(arr[n]);
    }
    static void recur(long num, int lastDigit){
        arr[idx++] = num;
        for(int i =0;i<lastDigit;i++){
            recur(num*10+i, i);
        }
    }
}
