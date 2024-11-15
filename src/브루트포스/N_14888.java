import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class N_14888 {
    /** 개쓰레기 코드
    static int [] num;
    static StringBuilder sb;
    static char [] op;
    static Set<String> visited;
    static int max;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n];
        op = new char[n-1];
        visited = new HashSet<>();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        sb = new StringBuilder();
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
            sb.append(num[i]);
        }

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for(int i=0;i<4;i++){
            int count = Integer.parseInt(st.nextToken());
            char c = 0;
            switch (i){
                case 0: c = '+'; break;
                case 1: c = '-'; break;
                case 2: c = '*'; break;
                case 3: c = '/'; break;
            }
            while(count -- > 0){
                op[idx++]=c;
            }
        }
        backtracking(1,sb,0);
        System.out.println(min+" "+max);
    }

    public static int calc(String str){
        int total =0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<str.length()-1;i++){
            char op = str.charAt(i);
            if(Character.isDigit(op)){
                stack.push(op-'0');
            }
            else{
                int a = stack.pop();
                int b =str.charAt(i+1)-'0';
                int calc =0;
                switch (op){
                    case '+':calc = a+b; break;
                    case '-':calc = a-b; break;
                    case '*':calc = a*b; break;
                    case '/':calc = a/b; break;
                }
                stack.push(calc);
            }
        }
        return stack.pop();
    }
    public static void backtracking(int depth, StringBuilder cur,int start){
        if(depth == num.length+op.length){
            int val = calc(cur.toString());
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }

        if(visited.contains(cur)){
            return;
        }
        for(int i=start;i<op.length;i++){
            cur.insert(depth,op[i]);
            visited.add(cur.toString()+depth);
            backtracking(depth+2, cur,i+1);
            cur.deleteCharAt(i);
        }
    }
     */

    static int []num;
    static int [] op;
    static int max;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        op = new int[4];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<num.length;i++){
            num[i]= Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<op.length;i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);
        System.out.println(min+" "+max);

    }
    public static void dfs(int n, int idx){
        if(idx >= num.length){
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }

        for(int i=0;i<4;i++){
            if(op[i]>0){
                op[i]--;
                switch (i){
                    case 0: dfs(n+num[idx], idx+1); break;
                    case 1: dfs(n-num[idx], idx+1); break;
                    case 2: dfs(n*num[idx], idx+1); break;
                    case 3: dfs(n/num[idx], idx+1); break;
                }
                op[i]++;
            }
        }
    }
}
