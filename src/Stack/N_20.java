package Stack;

import java.util.Stack;

public class N_20 {
    public static boolean isOpen(char c){
        return  c=='(' ||
                c=='{' ||
                c== '[';
    }
    public static char convertCloseToOpen(char close){
       if(close == ')') return '(';
       else if(close == ']') return '[';
       else return '{';
    }
    public static void main(String[] args) {
        Stack<Character> bracket = new Stack<>();
        String s ="()[]{}";
        for(char c : s.toCharArray()){
          if(isOpen(c)) bracket.push(c);
          else{
              if(bracket.isEmpty()){
                  System.out.println(false);
                  return;
              }
              char match = bracket.pop();
              c = convertCloseToOpen(c);
              if(c != match){
                  System.out.println(false);
                  return;
              }
          }
        }
        if(!bracket.isEmpty()){
            System.out.println(false);
            return;
        }
        System.out.println(true);
        return;
    }
}
