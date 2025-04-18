package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_10773 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        while(n >0){
            int cur = Integer.parseInt(br.readLine());
            if(cur ==0){
                stack.pop();
            } else{
                stack.push(cur);
            }
            n--;
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        System.out.println(sum);

    }
}
