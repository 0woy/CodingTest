package Stack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N_28278 {
    public static class Stack{
        List<Integer> stack;
        int top;

        public Stack(){
            this.stack = new ArrayList<>();
            top = -1;
        }
        public int isEmpty(){
            if(stack.isEmpty()){
                return 1;
            }else{
                return 0;
            }
        }
        public void push(int val){
            stack.add(val);
        }
        public int pop(){
            if(stack.isEmpty()){
                return -1;
            }else{
              return stack.remove(stack.size()-1);
            }
        }
        public int peek(){
            if(stack.isEmpty()){
                return -1;
            }else{
                return stack.get(stack.size()-1);
            }
        }

        public int size(){
            return stack.size();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int command =Integer.parseInt(st.nextToken());
            switch (command){
                case 1:
                    int val = Integer.parseInt(st.nextToken());
                    stack.push(val);
                    break;
                case 2:
                    bw.write(stack.pop()+"\n");
                    break;
                case 3:
                    bw.write(stack.size()+"\n");
                    break;
                case 4:
                    bw.write(stack.isEmpty()+"\n");
                    break;
                case 5:
                    bw.write(stack.peek()+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
