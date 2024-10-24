package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1654 {
  /** TimeOut
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        long goal = Integer.parseInt(st.nextToken());
        long [] lines = new long[k];

        for(int i=0;i<k;i++){
            lines[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(lines);
        long max = 0;
        long start = 0;
        for(long end : lines){
        while(start<end){
            long total=0;
            long len =(start+end)/2;
            if(len ==0){ break; }
            for(int i=lines.length-1;i>=0;i--){
                total +=(lines[i]/len);
                if(total>=goal){
                    start = len+1;
                    max = Math.max(len, max);
                    break;
                }
            }
            if(total<goal)
                end = len-1;
            }
        }
        System.out.println(max);
    }
   */
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int k = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int [] lines = new int[k];
      
      long max =0;
      for(int i=0;i<k;i++){
          lines[i] = Integer.parseInt(br.readLine());
          max = Math.max(max, lines[i]);
      }
      max++;

      long min =0;
      long len = 0;
      while(min < max){
          len = (min+max)/2;
          long count =0;
          for(int v : lines){
              count+=(v/len);
              if(count >= n){
                  min  = len+1;
                  break;
              }
          }
          if(count<n){
              max = len;
          }
      }
      System.out.println(min-1);
  }
}
