package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_19941 {
    /** Wrong.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int k  = Integer.parseInt(st.nextToken());

        int [] table = new int[n];
        String str= br.readLine();
        for(int i=0;i<table.length;i++) {
            char cur = str.charAt(i);
            if (cur == 'H') {
                table[i] = 1;
            } else {
                table[i] = 0;
            }
        }

        int count =0;
        for(int i=0;i<table.length;i++){
            if(table[i]==0){
                for(int pos =1;pos<=k;pos++){
                    int prevIdx = i-pos;
                    int nextIdx = i+pos;
                    if(prevIdx>=0 && table[prevIdx]==1){
                        table[prevIdx]=-1;
                        count++;
                        break;
                    }
                    if(nextIdx<table.length && table[nextIdx]==1){
                        table[nextIdx]=-1;
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char [] table = str.toCharArray();
        int count =0;
        for(int i=0;i<table.length;i++){
            char cur = table[i];
            if(cur == 'P'){
                int minIdx =Math.max(i-k,0);
                int maxIdx = Math.min(i+k,n-1);

                for(int j=minIdx;j<=maxIdx;j++){
                    if(table[j]=='H'){
                        table[j]='X';
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
