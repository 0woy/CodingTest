package TwoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1940 {
    /** 시간: O(N²)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int [] arr =new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=n-1;j>i;j--){
                if(arr[i]+arr[j]==m){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int [] arr =new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count=0;
        int i=0,j=n-1;
        while(i<j){
            if(arr[i]+arr[j]==m){
                count++;
                i++;j--;
            }
            else if(arr[i]+arr[j]<m){
                i++;
            }
            else{
                j--;
            }
        }
        System.out.println(count);
    }
}
