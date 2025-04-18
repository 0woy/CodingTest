package Stack;

import java.util.Stack;

public class N_150 {
    public static boolean isOperation(String text){
        boolean isop = false;
        switch (text){
            case "+":
            case "-":
            case "*":
            case "/":
                isop = true;
        }
        return isop;
    }
    public static int calc(int n1, int n2,String text){
        switch (text){
            case "+": return n1+n2;
            case "-": return n1-n2;
            case "*": return n1*n2;
            case "/": return n1/n2;
        }
        return -1;
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack =new Stack<>();
        for(String text : tokens){
            if(isOperation(text)){
                int num2 = stack.pop();
                int num1 = stack.pop();
             stack.push(calc(num1,num2,text));
            }
            else{
                stack.push(Integer.parseInt(text));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String[]  tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        System.out.println(evalRPN(tokens));
    }
}
