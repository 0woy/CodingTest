package Array;

import java.io.*;
import java.util.StringTokenizer;

public class N_1244 {
    /** Not working
    static int [] switches;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        switches = new int[n];
        int idx=0;
        while(st.hasMoreTokens()){
            switches[idx++] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());
        while(student -- >0){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            num -=1;
            if(sex == 1){
                int i=num;
                while(i<switches.length){
                    switches[i]= (switches[i]==0)?1:0;
                    i = i *mul;
                    mul++;
                }
            }else{
                int left = num;
                int right = num;
                do{
                    left--;
                    right++;
                    if(left<0 || right>=switches.length){
                        left++;
                        right--;
                        break;
                    }
                }while (switches[left] == switches[right]);

                for(int i=left;i<=right;i++){
                    switches[i]= (switches[i]==0)?1:0;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int v: switches){
            bw.write(v+" ");
        }
        bw.flush();
        bw.close();

    }
     */
    static int[] switches;

    public static void printSwitches(){
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<switches.length;i++){
            sb.append(switches[i]+" ");
            if(i%20==0){
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());

        switches = new int[n+1];
        for(int i=1;i<=n;i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int student = Integer.parseInt(br.readLine());
        while(student -- > 0){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            calc(sex, pos);
        }
        printSwitches();
    }
    public static void calc(int sex, int pos){
        if(sex == 1){
            for(int i=1;pos*i<switches.length;i++){
                switches[pos*i] =
                        (switches[pos*i]==0)?1:0;
            }
        }else{
            int start, end;
            start = end=pos;
            while(start >=2 && end<switches.length-1){
                start--;
                end++;
                if(switches[start]!=switches[end]){
                    start ++;
                    end--;
                    break;
                }
            }
            for(int i=start;i<=end;i++){
                switches[i] =
                        (switches[i]==0)?1:0;
            }
        }
    }

}
