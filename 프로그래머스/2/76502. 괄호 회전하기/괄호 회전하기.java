import java.util.*;
class Solution {
    public int solution(String s) {
        ArrayDeque<Character> que = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            que.add(c);            
        }
        
        int count =0;
        
        StringBuilder sb= new StringBuilder();
        for(int i=1;i<s.length();i++){            
            for(char c: que){
                sb.append(c);
            }
            
            count+= isCorrect(sb.toString());
            char head = que.poll();
            que.add(head);
            sb.setLength(0);                                 
        }
        return count;
    }
    
    public boolean isPair(char open, char close){
        return (open=='(' && close == ')') ||
            (open=='[' && close == ']') ||
            (open=='{' && close == '}');
        
    }
    public int isCorrect(String str){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(char ch : str.toCharArray()){
            if(ch == '(' || ch =='[' || ch=='{'){
                stack.addFirst(ch);
            }else{
                if(stack.isEmpty()) return 0;
                char open = stack.poll();
                boolean pair = isPair(open, ch);
                if(!pair) return 0;
            }
        }
        
        if(!stack.isEmpty()) return 0;
        
        return 1;
    }
}