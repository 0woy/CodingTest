import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");
            int len = Integer.parseInt(br.readLine());
            int first =0, second = len/2;
            if(len%2!=0) second+=1;
            int mid = second;

            String[] arr = br.readLine().split(" ");
            while(first<mid && second<len){
                sb.append(arr[first]+" ");
                sb.append(arr[second]+" ");
                first++;
                second++;
            }
            if(first<mid) sb.append(arr[first]);
            sb.append("\n");
        }
        System.out.println(sb);

    }

}
