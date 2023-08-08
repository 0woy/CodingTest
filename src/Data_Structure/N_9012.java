/*
N_9012 괄호
괄호 문자열(PS), 모양이 바르게 구성돼 있는 경우 VPS
VPS 여부 파악 후 YES || NO 출력

1. 직접 Stack을 구현한 경우, 메모리/시간 : 14252KB / 144ms
2. Stack 라이브러리 이용한 경우, 메모리/시간 : 14400KB / 132ms
 */

package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* Stack 직접 구현
class PS_Stack{
    int top;
    int size;
    Character [] arr;

    public PS_Stack(int size) {
        this.top = -1;
        this.size = size;
        this.arr = new Character[size];
    }

    public boolean is_empty(){return this.top==-1;}
    public void push(Character tmp){
        this.arr[++top] = tmp;
    }
    public boolean pop(){
        if(is_empty())
            return false;
        else{
            top--;
            return true;
        }
    }
}
*/

public class N_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<n;i++){
            String tmp = br.readLine();
            boolean res = true;

            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(j) == '(')
                    stack.push('(');
                else {
                    if (stack.isEmpty()) {
                        res = false;
                        break;
                    }
                    else
                        stack.pop();
                }
            }
            if (!stack.isEmpty()) res = false;
            sb.append(res ? "YES\n" : "NO\n");
            stack.clear();
        }
            System.out.println(sb);
    }
}
