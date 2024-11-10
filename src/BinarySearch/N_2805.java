package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_2805 {
    /** Wrong Ans
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long [] trees = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            trees[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(trees);

        long max = trees[n-1];
        long start =0;
        while(start<max){
            long total=0;
            long half = (start+max)/2;
            for(int i=trees.length-1;i>=0;i--){
                if(half>=trees[i]) break;
                total = total+trees[i]-half;

                if(total>m){
                    break;
                }
            }
            if(total > m){
                start=half+1;
            }
            else if(total<m){
                max = half-1;
            }
            else{
                System.out.println(half);
                return;
            }
        }
        System.out.println(start);
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] tree = new int[n];
        st =new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0;i<n;i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(tree[i], max);
        }
        int res =binary(tree,max,m);
        System.out.println(res);

    }

    public static int binary(int[] trees, int max, int m){
        int start = 0;
        while(start<max) {
            int half = (start + max) / 2;
            long total = 0;
            for (int v : trees) {
                if (v > half) {
                    total += v - half;
                    if(total>m){
                        break;
                    }
                }
            }
            if (total < m) {
                max = half;
            }
            else if(total>=m){
                start = half+1;
            }
        }
        return start-1;
    }

}
