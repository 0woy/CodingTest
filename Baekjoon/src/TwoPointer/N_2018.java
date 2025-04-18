package TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class N_2018 {
    /** Wrong
    public static boolean binarySearch(int[] sum,int start, int end, int goal){
        while(start <= end){
            int mid = (start + end)/2;
            if(goal == sum[mid]){return true;}
            if(goal > sum[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int [] sum = new int[n/2+2];
        sum[0] =0;
        for(int i=1, num=1;i<sum.length;i++){
            sum[i]=sum[i-1]+num;
            num++;
        }
        int count =1;
        for(int i=sum.length-1;i>=1;i--){
            int fix = sum[i];
            int j=1;
            while(j<i){
                if(fix-sum[j]==n){
                    count++;  break;
                }
                j++;
            }
        }
        System.out.println(count);
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int []arr = new int[n];
        int count =1;
        for(int i=1;i<=n;i++){
            arr [i-1] =i;
        }
        int sIdx =0, eIdx = 0;
        int sum=0;
        while (eIdx<n){
            if(sum == n){
                sum = sum + arr[eIdx];
                count++;
                eIdx++;
            }
            else if(sum<n){
                sum = sum + arr[eIdx];
                eIdx++;
            }else{
                sum-=arr[sIdx];
                sIdx++;
            }
        }
        System.out.println(count);
    }
}
