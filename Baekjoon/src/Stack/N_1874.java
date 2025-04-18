package Stack;

import java.io.*;
import java.util.Stack;

public class N_1874 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int [] goal = new int[n];

        for(int i=0;i<n;i++){
            goal[i]= Integer.parseInt(br.readLine());
        }
        int cIdx = 0;

        for(int i=1;i<=n;){
            if(i<=goal[cIdx]){
                stack.push(i);
                sb.append("+\n");
                i++;
            }else{
              int peek = stack.peek();
              if(peek!=goal[cIdx]){
                  System.out.println("NO");
                  return;
              }
            }
            if(stack.peek()==goal[cIdx]){
                stack.pop();
                sb.append("-\n");
                cIdx++;
            }
        }
        while(!stack.isEmpty()){
            if(stack.pop()!=goal[cIdx++]){
                System.out.println("NO");
                return;
            }
            sb.append("-\n");
        }
        System.out.print(sb.toString());
    }
}
