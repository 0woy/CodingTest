import java.io.*;
import java.util.*;

public class N_18111 {
    static Map<Integer, Integer> ground;
    static int b;
    /** 높이 차 간과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        ground = new HashMap<>();
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int key = Integer.parseInt(st.nextToken());
                ground.put(key, ground.getOrDefault(key, 0)+1);
            }
        }
        int [] keys = new int[ground.keySet().size()];
        int idx =0;
        for(int k: ground.keySet()){
            keys[idx++] =k;
        }
        Arrays.sort(keys);
        int min = Integer.MAX_VALUE;
        int rHeight = -1;
        for(int i= keys.length-1;i>=0;i--){
            int time = calc(keys[i]);
            if(time == -1){
                continue;
            }
            if(time < min){
                min  = time;
                rHeight = keys[i];
            }
        }
        System.out.println(min+" "+rHeight);
    }

    public static int calc(int height){
        int have = b;
        int time = 0;
        for(int k : ground.keySet()){
            int count =ground.get(k);
            if(k>height){
                time += count*2;
                have+=count;
            }else if(k<height){

                if(have<count){    // 채울 수 없는 경우
                    return -1;
                }
                else{
                    time += count;
                    have-=count;
                }
            }
        }
        return time;
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int cMax = -1;
        int cMin = 256;
        ground = new HashMap<>();
        while(n-- > 0){
            st= new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int k = Integer.parseInt(st.nextToken());
                ground.put(k,ground.getOrDefault(k, 0)+1);
                cMax = Math.max(cMax, k);
                cMin = Math.min(cMin, k);
            }
        }
        if(ground.keySet().size()==1){
            System.out.println(0+" "+cMax);
            return;
        }

        int res= Integer.MAX_VALUE;
        int height =0;
        for(int h =cMin;h<=cMax;h++){
            int time = getHeight(h);
            if(time > -1){
                if(time <= res){
                    res =time;
                    height = Math.max(height, h);
                }
            }
        }
        System.out.println(res+" "+height);
    }

    public static int getHeight(int height){
        int blocks = b;
        int  time =0;
        for(int h : ground.keySet()){
            int count =ground.get(h);
            int diff = Math.abs(height-h); // 높이차
            if(h>height){   // 제거
                time +=count*diff*2;
                blocks+=count*diff;
            }
            else if(h < height){    // 추가
                time +=count*diff;
                blocks-=count*diff;
            }
        }
        if(blocks<0){
            return -1;
        }
        return time;
    }
}
