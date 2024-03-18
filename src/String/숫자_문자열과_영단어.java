package String;

public class 숫자_문자열과_영단어 {
    class Solution {
        public int solution(String s) {
            StringBuilder sb =new StringBuilder();
            char next ='\0';

            for(int i=0;i<s.length();){
                char tmp = s.charAt(i);
                int plus =0;
                if(tmp >= '0' && tmp <='9'){
                    sb.append(Integer.parseInt(String.valueOf(tmp)));
                    i+=1;
                }
                else{
                    switch(tmp){
                        case 'z': sb.append(0); plus =4; break;
                        case 'o': sb.append(1); plus =3; break;
                        case 't':
                            if(s.charAt(i+1)=='w'){
                                sb.append(2); plus=3;
                            }
                            else {
                                sb.append(3); plus=5;
                            }
                            break;
                        case 'f':
                            if(s.charAt(i+1)=='o')
                                sb.append(4);
                            else
                                sb.append(5);
                            plus=4;
                            break;
                        case 's':
                            if(s.charAt(i+1)=='i'){
                                sb.append(6);
                                plus =3;
                            }
                            else {
                                sb.append(7);
                                plus=5;
                            }
                            break;
                        case 'e': sb.append(8); plus = 5; break;
                        case 'n': sb.append(9); plus = 4;break;
                    }
                    i+=plus;
                }
            }
            return Integer.parseInt(String.valueOf(sb));
        }
    }
}
