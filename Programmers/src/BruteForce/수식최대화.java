package BruteForce;

import java.util.*;

public class 수식최대화 {
    /** First Try
    public static long calculate(long n1, long n2, String op){
        switch (op){
            case "+" : return n1+n2;
            case "*" : return n1*n2;
            case  "-" :return n1-n2;
        };
        return 0;
    }
    public static List<String> getTokens(String expression){
        List<String> tokens = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : expression.toCharArray()){
            if(Character.isDigit(ch)){
                sb.append(ch);
            }
            else{
                if(sb.length()>0){
                    tokens.add(sb.toString());
                    sb.setLength(0);
                }
                tokens.add(String.valueOf(ch));
            }
        }
        if(sb.length()>0){
            tokens.add(sb.toString());
        }
        return tokens;
    }
    public static long solution(String expression) {
        List<String> list = getTokens(expression);
        for(String [] orders: order){

        }
        for(String op: orders){
            for(int i=0;i<list.size();i++){
                if(list.get(i).equals(ops[idx])){
                    long n1 = Long.parseLong(list.get(i-1));
                    long n2 = Long.parseLong(list.get(i+1));
                    long res = calculate(n1,n2,ops[idx]);
                    list.remove(i-1);
                    list.remove(i-1);
                    list.remove(i-1);
                    list.add(i-1,String.valueOf(res));
                    i-=2;
                }
            }
        }

        long max =0;
        System.out.println( list.get(0));

//        System.out.println(answer);
        return max;
    }
     */
    public static String[][] orders = {
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*-+".split(""),
            "*+-".split(""),
    };
    public static long calc(long n1, long n2, String op){
        switch (op){
            case "+": return n1+n2;
            case "-": return n1-n2;
            case "*": return n1*n2;
        }
        return 0;
    }
    public static long calculate(String[] ops, List<String> list){
        for(String op: ops){
            for(int i=0;i<list.toArray().length;i++){
                if(list.get(i).equals(op)){
                    long n1 =  Long.parseLong(list.get(i-1));
                    long n2 =  Long.parseLong(list.get(i+1));
                    long res = calc(n1,n2,op);
                    list.remove(i-1);
                    list.remove(i-1);
                    list.remove(i-1);
                    list.add(i-1, String.valueOf(res));
                    i-=2;
                }
            }
        }
        System.out.println(list.get(0));
        return Long.parseLong(list.get(0));
    }

    public static List<String> getTokens(String expression){
        List<String> tokens = new LinkedList<>();
        StringBuilder sb= new StringBuilder();

        for(char ch : expression.toCharArray()){
            if(Character.isDigit(ch)){
                sb.append(ch);
            }
            else{
                if(sb.length()>0){
                    tokens.add(sb.toString());
                    sb.setLength(0);
                }
                tokens.add(String.valueOf(ch));
            }
        }
        if(sb.length()>0){
            tokens.add(sb.toString());
        }
        return tokens;
    }
    public static  long solution(String expression) {
        long max = 0;
        List<String> tokens = getTokens(expression);
        for(String[] ops : orders){
            max = Math.max(max, Math.abs(calculate(ops, new LinkedList<>(tokens))));
        }
        return max;
    }
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        solution(expression);

    }
}
