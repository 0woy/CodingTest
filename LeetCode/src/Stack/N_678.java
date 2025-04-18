package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class N_678 {
    /** My Solve, 공간:O(N)
    public static boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else if (c=='*'){
                que.add(i);
            }else{
                if(stack.isEmpty()){
                   if (que.isEmpty()){
                       return false;
                   }else{
                       que.pollLast();
                   }
                }else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()){
            if(que.isEmpty()){
                return false;
            }
            int top = stack.pop();
            if(top>que.peekLast()){
                return false;
            }
            que.pollLast();
        }
        return true;
    }*/
    public static boolean checkValidString(String s) {
        int min = 0, max = 0;
        for(char c: s.toCharArray()){
            switch (c){
                case '(': min++;    max++; break;
                case ')': min--;    max--; break;
                case '*': min--;    max++; break;
            }
            if(max < 0 ) return false;
            if(min < 0) min=0;
        }
        if(min==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "*(((*))";
        System.out.println(checkValidString(s));

    }
}
