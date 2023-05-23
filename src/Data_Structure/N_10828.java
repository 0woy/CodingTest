package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Stack{
private int top;
private int size;
private int [] data;
    public Stack(){
        this.top=0;
        this.size =0;
        this.data = new int[100000];
    }
    public Stack(int size){
        super();
        this.data = new int[size];
    }

    public void push(int value){
        this.size+=1;
        this.data[top++] = value;
    }
    public int getSize(){return this.size;}
    public int getTop(){
    if(isEmpty()==1) return -1;
    else return this.data[this.top-1];
    }

    public int isEmpty(){
        if(this.top==0) return 1;
        else return 0;
    }
    public int pop(){
        if(isEmpty()==1){  // 스택이 비어있는 경우
            return -1;
        }
        else {
            this.size-=1;
            return this.data[--top];
        }
    }
}

public class N_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack(n);


        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    int data = Integer.parseInt(st.nextToken());
                    stack.push(data);
                    break;
                    case "pop":
                    System.out.println(stack.pop());
                    break;
                case "top":
                    System.out.println(stack.getTop());
                    break;
                case "size":
                    System.out.println(stack.getSize());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty());
                    break;
            }
        }

    }
}
