package Stack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N_10828 {
    public static class Stack{
        int top;
        List<Integer> stack;
        public Stack(){
            stack = new ArrayList<>();
            top = -1;
        }
        public void push(int n){
            stack.add(n);
            top++;
        }
        public int pop(){
            if(stack.isEmpty()){
                return -1;
            }
            return stack.remove(top--);
        }
        public boolean isEmpty(){
            return top==-1?true:false;
        }
        public int top(){
            if(stack.isEmpty()){
                return -1;
            }
            return stack.get(top);
        }
        public int size(){
            return top+1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        while(n>0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.pop()+"\n");
                    break;
                case "top":
                    sb.append(stack.top()+"\n");
                    break;
                case "empty":
                    int isEmpty = stack.isEmpty()?1:0;
                    sb.append(isEmpty+"\n");
                    break;
                case "size":
                    sb.append(stack.size()+"\n");
                    break;
            }
            n--;
        }
        System.out.print(sb.toString());
    }
}
