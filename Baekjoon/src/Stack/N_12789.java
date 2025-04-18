package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class N_12789 {
    /** Wrong
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int [] arr =new int[n];
        int cur =1;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n-1;i++){
            if(arr[i+1]<arr[i]){
                stack.push(arr[i]);
            }else{
                if(stack.isEmpty()){
                    System.out.println("Sad");
                    return;
                }
                if(stack.peek()<arr[i]){
                    if(stack.peek()==cur){
                        stack.pop();
                        cur++;
                    }
                }
                if(arr[i]==cur){
                    cur++;
                }
                else{
                    System.out.println("Sad");
                    return;
                }
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()!=cur){
                if(arr[n-1]==cur){
                    cur++;
                    continue;
                }
                else {
                    System.out.println("Sad");
                    return;
                }
            }
            else{
                stack.pop();
                cur++;
            }
        }
        System.out.println("Nice");
        return;
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> que =new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            que.add(Integer.parseInt(st.nextToken()));
        }
        int cur =1;
        while (!que.isEmpty()){
            if(que.peek() == cur){
                que.poll();
                cur++;
            }else if(!stack.isEmpty() && stack.peek() == cur){
                stack.pop();
                cur++;
            }else{
                stack.push(que.poll());
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()==cur){
                stack.pop();
                cur++;
            }else{
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
