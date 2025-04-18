package Stack;

import java.util.Stack;

public class N_394 {
    /** FirstTry: WRONG
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringBuilder str = new StringBuilder();
        for(char cur : s.toCharArray()){
            if(cur == ']'){
                while(true){
                    char top = stack.pop();
                    if(Character.isDigit(top)){
                        StringBuilder num = new StringBuilder();
                        num.insert(0,top);
                        while(!stack.isEmpty()){
                            if(Character.isDigit(stack.peek())){
                                top = stack.pop();
                                num.insert(0,top);
                            }
                            else{
                                break;
                            }
                        }
                        int repeat =  Integer.parseInt(num.toString());
                        if(stack.isEmpty()){
                            for(int i=0;i<repeat;i++){
                                res.append(str);
                            }
                            str.setLength(0);
                        }
                        else{
                            for(int i=0;i<repeat-1;i++){
                                str.append(str);
                            }
                        }
                        break;
                    }
                    else if(Character.isAlphabetic(top )){
                        str.insert(0,top );
                    }
                    else continue;
                }
            }
            else {
                if(stack.isEmpty()&&Character.isAlphabetic(cur)){
                    res.append(cur);
                }
                else {
                    stack.push(cur);
                }
            }
        }
        while(!stack.isEmpty()){
            str.insert(0,stack.pop());
        }
        res.append(str);
        System.out.println(res);
        return res.toString();
    }
     */
    public static String decodeString(String s) {
        Stack<Integer> nStack =new Stack<>();
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        int n =0;
        for(char cur: s.toCharArray()){
            if(Character.isDigit(cur)){
                n = n*10 + (cur-'0');
            }
            else if(cur == '['){
                nStack.push(n);
                n=0;
                stack.push(str);
                str = new StringBuilder();
            }
            else if(cur==']'){
                int k = nStack.pop();
                StringBuilder tmp = str;
                str = stack.pop();
                while(k-- >0){
                    str.append(tmp);
                }
            }
            else {
                str.append(cur);
            }
        }
        System.out.println(str);
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        decodeString(s);
    }
}
