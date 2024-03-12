package String;

public class 문자열_압축 {
    class Solution {
        public static int check(String token, String s){
            int token_len = token.length();
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for(int i=token_len;i<=s.length();i+=token_len){

                int e_idx= i+token_len;

                if(e_idx > s.length()){
                    sb.append(token);
                    token =  s.substring(i,s.length());
                    break;
                }

                else if(token.equals(s.substring(i,e_idx)))
                    count+=1;
                else{
                    if(count == 1)
                        sb.append(token);
                    else
                        sb.append(count+token);

                    token = s.substring(i,i+token_len);
                    count =1;
                }
            }
            if(count==1) sb.append(token);
            else    sb.append(count+token);
            return sb.length();
        }

        public int solution(String s) {
            // 1개, 2개... s전체 만큼 문자열 분리
            if(s.length() == 1) return 1;
            int min = Integer.MAX_VALUE;
            for(int i=1;i<s.length()/2+1;i++){
                String token = s.substring(0, i);
                int count = check(token,s);
                if(count!=0)
                    min = (min > count)?count:min;
            }
            int answer = 0;
            return min;
        }
    }
}
