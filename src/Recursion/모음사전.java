package Recursion;

public class 모음사전 {
    public static int multiple(char ch){
        int mul = 1;
        switch (ch){
            case 'A':   mul=0; break;
            case 'E':   mul=1; break;
            case 'I':   mul=2; break;
            case 'O':   mul=3; break;
            case 'U':   mul=4; break;
        }
        return mul;
    }
    public static int solution(String word) {
        int answer = 0;
        int [] nums = new int[]{781,156,31,6,1};
        for(int i=0;i<word.length();i++){
            int mul = multiple(word.charAt(i));
            answer+= nums[i]*mul+1;
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        String word = "IOA";
        solution(word);
    }
}
