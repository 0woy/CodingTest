import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static class Food {
        int taste;
        int kal;

        public Food(int t, int k) {
            this.taste = t;
            this.kal = k;
        }
    }
    static int limit;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            sb.append("#" + t + " ");
            int[] val = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = val[0];
            limit = val[1];
            max = 0;
            Food[] foods = new Food[n];
            for (int i = 0; i < foods.length; i++) {
                int[] info = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                foods[i] = new Food(info[0], info[1]);
            }
            Arrays.sort(foods, (a, b)->{
                if(a.kal == b.kal){ return Integer.compare(b.taste, a.taste);}
                return Integer.compare(a.kal, b.kal);
            });
            comb(foods, 0, 0,0);
            sb.append(max+"\n");
        }
        System.out.println(sb);
    }
    static void comb(Food[] foods, int idx, int total, int flavor){
        max = Math.max(max, flavor);
        for(int i=idx;i<foods.length;i++){
            if(total+foods[i].kal <= limit)
                comb(foods, i+1, total+foods[i].kal, flavor+foods[i].taste);
        }
    }
}
