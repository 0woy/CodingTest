package KB.week01;

import java.util.ArrayList;
import java.util.List;

public class 문자열압축 {
    /** Wrong
    public static int solution(String s) {
        int result =s.length();
        for(int range=1;range<=s.length()/2;range++){
            StringBuilder answer =new StringBuilder();
            for(int idx=0;idx+range<=s.length();){
                String token =s.substring(idx, idx+range);
                int j=idx;
                int count =1;
                for(;j+range<=s.length();j+=range){
                    String compare =s.substring(j,j+range);
                    if(token.equals(compare)){
                        count++;
                    }else{
                        break;
                    }
                }
                if(count>1){
                    answer.append(count);
                }
                answer.append(token);
                idx = j;
            }
            result = Math.min(result, answer.length());
        }
        return result;
    }
*/
    public static int solution(String s){
       int res = s.length();
       for(int r=1;r<=s.length()/2;r++){
           res =Math.min(res,compression(s, r));
       }
       return res;
    }
    public static int compression(String s, int len){
        List<String> words = new ArrayList<>();
        for(int i=0;i<s.length();i+=len){
            words.add(s.substring(i,Math.min(s.length(), i+len)));
        }

        StringBuilder compression = new StringBuilder();
        int count = 0;
        String prev ="";
        for(String w:words){
            if(w.equals(prev)){
                count++;
            }else{
                if (count>1){
                    compression.append(count);
                }
                compression.append(prev);
                prev = w;
                count = 1;
            }
        }
        if(count>1){
            compression.append(count);
        }
        compression.append(prev);
        return compression.toString().length();
    }
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
}

