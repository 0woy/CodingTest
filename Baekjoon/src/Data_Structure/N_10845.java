package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Que{
    private int front, rear,size;    // push, pop 연산에 사용할 변수
    private final int count;
    private int[] arr;
    
    public Que(int len){
        this.front=0;
        this.rear=0;
        this.count=len;
        this.size=0;
        this.arr = new int[len];
    }
    
    // 큐가 비어있는 경우
    public boolean is_empty(){
        return this.front==this.rear;
    }
    
    // 큐가 가득찬 경우
    public boolean is_full(){
        return (this.rear + 1) % this.count == this.front;
    }
    
    // push 명령
    public void push(int x){
        if(!is_full()) {
            this.size+=1;
            this.arr[++this.rear] = x;
        }
    }

    // pop 명령
    public void pop(){
        if(!is_empty()){ System.out.println(this.arr[++this.front]); size--;}
        else System.out.println(-1);
    }

    public void size(){
        System.out.println( this.size);
    }

    // flag가 참인 경우 맨 앞 정수 출력
    public void FrontOrBack(boolean flag){
        if(!is_empty()) System.out.println(flag? arr[front+1]:arr[rear]);
        else System.out.println(-1);
    }
}

public class N_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Que queue = new Que(count); // 큐 초기화
        
        for(int i=0;i<count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
                switch (command) {
                    case "push":
                        int num = Integer.parseInt(st.nextToken());
                        queue.push(num);
                        break;
                    case "front":
                    case "back":
                        queue.FrontOrBack(command.equals("front")); break;
                    case "size": queue.size();  break;
                    case "pop":  queue.pop();   break;
                    case "empty": System.out.println(queue.is_empty() ? 1 : 0); break;
                }
        }
    }
}
