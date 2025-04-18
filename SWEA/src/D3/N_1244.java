package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1244 {
    /** Wrong
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            sb.append("#"+t+" ");
            st = new StringTokenizer(br.readLine());
            String str= st.nextToken();
            Integer [] num = new Integer[str.length()];
            for(int i=0;i<num.length;i++){
                num[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            int change = Integer.parseInt(st.nextToken());

            int i = 0;
            int count =0;
            while(count<change && i<num.length){
                int first = num[i];
                int max =Integer.MIN_VALUE;
                int pos = -1;
                for(int j=num.length-1;j>i;j--){
                    if(max < num[j]){
                        pos = j;
                        max =num[j];
                    }
                }
                if(max > first){
                    int tmp = num[i];
                    num[i] = num[pos];
                    num[pos] = tmp;
                    count++;
                }
                i++;
            }

            Arrays.sort(num, num.length-change, num.length, Collections.reverseOrder());
            for(int c: num){
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
     */

    static int res;
    static int [] num;
    static Set<String> visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc =Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            res = Integer.MIN_VALUE;
            sb.append("#"+t+" ");
            st = new StringTokenizer(br.readLine());
            String str =st.nextToken();
            int change = Integer.parseInt(st.nextToken());
            num = new int[str.length()];
            visited = new HashSet<>();

            for(int i=0;i<num.length;i++){
                num[i] = str.charAt(i)-'0';
            }
            backtracking(0,change);
            sb.append(res+"\n");
        }
        System.out.println(sb.toString());
    }

    public static int calc(){
        int total=0;
        int mul = 1;
        for(int i=num.length-1;i>=0;i--){
            total +=  num[i]*mul;
            mul*=10;
        }
        return total;
    }
    public static void backtracking(int depth, int change){
        if(depth==change){
            res = Math.max(res, calc());
            return;
        }

        String curState = Arrays.toString(num)+depth;
        if(visited.contains(curState)){
            return;
        }
        visited.add(curState);
        for(int i=0;i<num.length-1;i++){
            for(int j=i+1;j<num.length;j++){
                swap(i,j);
                backtracking(depth+1, change);
                swap(i,j);
            }
        }
    }

    public static void swap(int i, int j){
        int tmp = num[i];
        num[i]= num[j];
        num[j]= tmp;
    }
}
