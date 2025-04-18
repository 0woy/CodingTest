package Stack;

import java.util.Stack;

public class N_224 {
    /** 1. Runtime Error
    public static boolean isOperator(String str){
        return str.equals("+") || str.equals("-");
    }

    public static String calc(String n1, String  op,String  n2){
        int a = Integer.parseInt(n1);
        int b = Integer.parseInt(n2);
        switch (op){
            case "+": return String.valueOf(a+b);
            case "-": return String.valueOf(a-b);

        }
        return "";
    }
    public static int calculate(String s) {
        Stack<String> stack =new Stack<>();
        int result =0;
        s = s.replaceAll(" ","");
        char[] stoc = s.toCharArray();
        for(int i=0;i<stoc.length;i++){
            char cur = stoc[i];
            if(isOperator(String.valueOf(cur))){
                char prev = stoc[i-1];
                if(Character.isDigit(prev)){
                    String n1 = stack.pop();
                    String n2 = String.valueOf(stoc[i+1]);
                    stack.push(calc(n1, String.valueOf(cur), n2));
                    i++;
                }
                else{
                    stack.push(String.valueOf(cur+prev));
                }
            }
          else if(cur==')'){
              String n2="";
              while(!stack.peek().equals("(")){
                  n2 = stack.pop();
                }
              stack.pop();
              if(!stack.isEmpty() && isOperator(stack.peek())){
                  String op = stack.pop();
                  String n1 = stack.pop();
                  stack.push(calc(n1,op,n2));
              }
              else{
                  stack.push(n2);
              }
            }
          else{
              stack.push(String.valueOf(cur));
            }
        }
        StringBuilder sb= new StringBuilder();
        if(stack.size()==1){
            return Integer.parseInt(stack.pop());
        }
        else {
            while (stack.size() > 0) {
                sb.append(stack.pop());
            }
        }
        result=Integer.parseInt(sb.reverse().toString());
        return result;
    }
     */
    /** 2. Wrong Answer
    public static boolean isOperation(char ch){
        return ch=='+'||ch=='-';
    }
    public static String calc(String n1, String op, String n2){
        int res =0;
        switch (op){
            case "+": return String.valueOf(Integer.parseInt(n1)+Integer.parseInt(n2));
            case "-": return String.valueOf(Integer.parseInt(n1)-Integer.parseInt(n2));
        }
        return "";
    }
    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        s = s.replaceAll(" ","");
        char [] part=  s.toCharArray();
        for(int i=0;i<part.length;i++){
            char current = part[i];
            if(Character.isDigit(current)){
                stack.push(String.valueOf(current));
            }
            else if(isOperation(current)){
                if(!Character.isDigit(part[i-1])){
                    StringBuilder sb = new StringBuilder(String.valueOf(current) + String.valueOf(part[i + 1]));
                    stack.push(sb.toString());
                    i++;
                }
                else if(!Character.isDigit(part[i+1])){
                    stack.push(String.valueOf(current));
                }
                else{
                    String n1 = stack.pop();
                    String op = String.valueOf(current);
                    String n2 = String.valueOf(part[i+1]);
                    stack.push(calc(n1,op,n2));
                }
            }
            else{
                if(current == ')'){
                    String n2 = stack.pop();
                    stack.pop();
                    stack.push(n2);
                }
                else {
                    stack.push(String.valueOf(current));
                }
            }
        }
        if(stack.size()==1){
            return Integer.parseInt(stack.pop());
        }
        else{
            StringBuilder sb = new StringBuilder();
            while(stack.size()>0){
                String cur = stack.pop();
                if(isOperation(cur.charAt(0))){
                    String n2 = String.valueOf(sb.deleteCharAt(0));
                    if(stack.size()>0){
                        String n1 = stack.pop();
                        stack.push(calc(n1,cur, n2));
                    }
                    else{
                        stack.push(String.valueOf(Integer.parseInt(n2)*-1));
                    }
                    sb.append(stack.pop());
                }
                else{
                    sb.append(cur);
                }
                return Integer.parseInt(sb.reverse().toString());
            }
        }
        return 1;
    }
     */
    /** 3. Wrong Answer
    public static boolean isOpersation(char ch){
        return ch=='+' || ch=='-';
    }
    public static boolean isParenthesis(char ch){
        return ch=='(' || ch==')';
    }
    public static String afterNums(char[] chars, int start){
        int last = start;
        StringBuilder sb=  new StringBuilder();
        while(Character.isDigit(chars[last])){
            sb.append(chars[last++]);
            if(last>=chars.length){
                break;
            }
        }

        return sb.toString();
    }

    public static String calc(String n1, String op, String n2){
        int a = Integer.parseInt(n1);
        int b = Integer.parseInt(n2);
        switch (op){
            case "+":
                return String.valueOf(a+b);
            case "-":
                return String.valueOf(a-b);
        }
        return "";
    }
    public static boolean isNotInteger(String str){
        try{
            Integer.parseInt(str);
            return false;
        }catch (NumberFormatException e){
            return true;
        }
    }
    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        s = s.replaceAll(" ","");
        char [] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            char cur = chars[i];
            if(isOpersation(cur)){
                String afterNum  =afterNums(chars,i+1);
                if(afterNum.equals("")){
                    //1. 뒤 숫자가 없는 경우: push
                    stack.push(String.valueOf(cur));
                    continue;
                }
                if(stack.size()==0 || isNotInteger(stack.peek())){
                    //2. (-): 앞 숫자가 없는 경우: 뒤에는 숫자이므로 묶어서 push
                    stack.push(cur+afterNum);
                    i+=afterNum.length();
                    continue;
                }
                //3. 앞 뒤 둘 다 숫자인 경우 계산 후 push
                stack.push(calc(stack.pop(), String.valueOf(cur), afterNum));
                i+=afterNum.length();
            }
            else if(isParenthesis(cur)){
                // 괄호인 경우
                if(cur == ')'){
                    StringBuilder sb = new StringBuilder();
                    while(!stack.peek().equals("(")){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    if(sb.length()>=3){
                        String n1 = sb.substring(0,1);
                        String op= sb.substring(1,2);
                        String n2= sb.substring(2,3);
                        stack.push( calc(n1,op,n2));
                        continue;
                    }
                    stack.push(sb.toString());
                }
                else{
                    stack.push(String.valueOf(cur));
                }
            }
            else{
                // 어디까지 숫자인지 파악하기
                String num = afterNums(chars , i);
                stack.push(num);
                if(num.length()>1)
                    i+=num.length();
            }
        }
        if(stack.size()>=3){
            String n2 = stack.pop();
            String op = stack.pop();
            String n1 = stack.pop();
            return Integer.parseInt(calc(n1,op,n2));
        }
        else if(stack.size()>=2){
            String n1 = stack.pop();
            String op = stack.pop();
            return Integer.parseInt(op+n1);
        }
        else{
            return Integer.parseInt(stack.pop());
        }
    }
     */

    public static int[] calc(char[] exp, int idx){
        int number = 0;
        int sign = 1;
        int result =0;
        for(int i=idx;i<exp.length;i++){
            char cur = exp[i];
            if(Character.isDigit(cur)){
                number= 10*number + (cur-'0');
            }
            else{
                result+=sign*number;
                if(cur=='+'||cur=='-'){
                    sign = cur=='+'?1:-1;
                }
                else if(cur=='('){
                    int [] arr = calc(exp, i+1);
                    result+=sign*arr[0];
                    i=arr[1];
                }
                else if(cur==')'){
                    return new int[]{result,i};
                }
                number=0;
            }
        }
        result+=sign*number;
        return new int[]{result,0};
    }
    public static int calculate(String s) {
        s= s.replaceAll(" ","");
       return calc(s.toCharArray(), 0)[0];
    }
    public static void main(String[] args) {
        String s =  "(1+(4+5+2)-3)+(6+8)";
        System.out.println( calculate(s));
    }
}
