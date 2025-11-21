import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        int tc =  Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");

            int n =Integer.parseInt(br.readLine());
            int [] score = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int max = Arrays.stream(score).sum();
            int [] dp = new int[max+1];
            dp[0]=1;
            for(int v: score){
                int [] tmp = dp.clone();
                for(int i=0;i<dp.length;i++){
                    if(dp[i] == 1 && i+v <= max){
                        tmp[i+v]=1;
                    }
                }
                dp = tmp;
            }
            long count = Arrays.stream(dp).filter(a -> a==1).count();
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int tc = Integer.parseInt(br.readLine());
//        for (int t = 1; t <= tc; t++) {
//            sb.append("#" + t + " ");
//            int n = Integer.parseInt(br.readLine());
//            int [][] arr =new int[n][2];
//            for (int i = 0; i < n; i++) {
//                arr[i] =Arrays.stream(br.readLine().split(" "))
//                        .mapToInt(Integer::parseInt)
//                        .sorted()
//                        .toArray();
//            }
//            Arrays.sort(arr, (a,b)->{ return a[0]-b[0];});
//            int total = 1;
//            int left= arr[0][0];
//            int right= arr[0][1];
//            for(int i=1;i<n;i++){
//                if(arr[i][0] <= right){
//                    right = Math.max(arr[i][1], right);
//                    total++;
//                }
//            }
//            sb.append(total+"\n");
//        }
//        System.out.println(sb);
//    }
}
