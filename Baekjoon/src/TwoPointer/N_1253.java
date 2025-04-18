package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr =new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count =0;
        for(int k=0;k<n;k++){
            int i=0,j=n-1;
            while(i<j){
                if(arr[i]+arr[j]==arr[k]){
                    if(i!=k && j!=k) {
                        count++;
                        break;
                    }
                    else if(i==k){
                        i++;
                    }else{
                        j--;
                    }
                }
                else if(arr[i]+arr[j]>arr[k]){
                    j--;
                }else{
                    i++;
                }
            }
        }
        System.out.println(count);
    }
}
