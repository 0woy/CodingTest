package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_11723 {
    public static class Set{
        boolean [] set;
        public Set(){
            this.set = new boolean[21];
        }
        public void add(int x){
            set[x] = true;
        }
        public void remove(int x){
            set[x]=false;
        }
        public void toggle(int x){
            set[x] = !set[x];
        }
        public void all(){
            Arrays.fill(set, true);
        }
        public void empty(){
            Arrays.fill(set, false);
        }
        public int check(int x){
            return (set[x])?1:0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Set set = new Set();
        while(n>0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x=0;
            if(!command.equals("all") && !command.equals("empty")){
                x = Integer.parseInt(st.nextToken());
            }
            switch (command){
                case "add":
                    set.add(x);
                    break;
                case "remove":
                    set.remove(x);
                    break;
                case "check":
                    sb.append(set.check(x)+"\n");
                    break;
                case "toggle":
                    set.toggle(x);
                    break;
                case "all":
                    set.all();
                    break;
                case "empty":
                    set.empty();
                    break;

            }
            n--;
        }
        System.out.print(sb.toString());
    }
}
