package Stack;

import java.util.Stack;

public class N_227 {

    /** First Try : RunTimeError
    public static String nextNumb(char [] ch, int idx){
        StringBuilder sb = new StringBuilder();
        while(idx<ch.length&&Character.isDigit(ch[idx])){
            sb.append(ch[idx++]);
        }
        return sb.toString();
    }
    public static int calculate(String s) {
        s= s.replaceAll(" ","");
        Stack<String> stack = new Stack<>();
        char [] ex = s.toCharArray();
        for(int i=0;i<ex.length;i++){
            char cur = ex[i];
            if(Character.isDigit(cur)){
                String number = nextNumb(ex, i);
                stack.push(number);
                i+=number.length()-1;
            }
            else {
                if(cur=='*'||cur=='/'){
                    String n2 = nextNumb(ex,i+1);
                    String n1 = stack.pop();
                    stack.push(calc(n1,cur,n2));
                    i+=n2.length();
                }
                else{
                    stack.push(String.valueOf(cur));
                }
            }
        }
        while(stack.size()>1){
            String n2 = stack.pop();
            char op=stack.pop().charAt(0);
            String n1=stack.pop();
            stack.push(calc(n1, op,n2));
        }
        int res =Integer.parseInt(stack.pop());
        return  res;
    }

 */
    /** Second Try: Access
    public static Stack<String> stack;
    public static String calc(String n1, char op, String n2){
        int a = Integer.parseInt(n1);
        int b = Integer.parseInt(n2);
        switch (op){
            case '+': return String.valueOf(a+b);
            case '-': return String.valueOf(a-b);
            case '*': return String.valueOf(a*b);
            case '/': return String.valueOf(a/b);
        }
        return "";
    }
    public static int numslastIndx(char [] exp, int start){
        while(start<exp.length&&Character.isDigit(exp[start])){
            start++;
        }
        return start;
    }
    public static void calcStack(){
        if(stack.size()<3){
            return;
        }
        while(stack.size()>=3){
            String n2 = stack.pop();
            char op = stack.pop().charAt(0);
            String n1 = stack.pop();
            stack.push(calc(n1,op,n2));
        }
    }
    public static boolean isOperation(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/';
    }
    public static int calculate(String s) {
        s=s.replaceAll(" ","");
        stack = new Stack<>();
        char [] exp = s.toCharArray();
        for(int i=0;i<exp.length;i++){
            char current = exp[i];
            if(Character.isDigit(current)){
               int last = numslastIndx(exp, i);
               stack.push(s.substring(i,last));
               i=last-1;
            }
            else if(isOperation(current)){
                if(current=='*' || current=='/'){
                    String n1 = stack.pop();
                    int last = numslastIndx(exp,i+1);
                    String n2 = s.substring(i+1,last);
                    stack.push(calc(n1,current,n2));
                    i = last-1;
                }
                else{
                    calcStack();
                    stack.push(String.valueOf(current));
                }
            }
            else{
              continue;
            }
        }
        while(stack.size()>1){
            calcStack();
        }
        return Integer.parseInt(stack.pop());
    }
     */

    public static int calculate(String s) {
        int number = 0;
        char sign = '+';
        s=s.replaceAll(" ","");
        Stack<Integer> stack = new Stack<>();
        char [] exp = s.toCharArray();
        for(int i=0;i<exp.length;i++){
            char cur = exp[i];
            if(Character.isDigit(cur)){
                number = 10*number+(cur-'0');
            }
            if(!Character.isDigit(cur) || i==exp.length-1){
                if(sign=='+'){
                    stack.push(number);
                }
                else if(sign=='-'){
                    stack.push(-number);
                }
                else if(sign=='*'){
                    stack.push(stack.pop()*number);
                }
                else if(sign=='/'){
                    stack.push(stack.pop()/number);
                }
                number=0;
                sign =cur;
            }
        }
        int result =0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(calculate(" 3/2 "));
    }
}
