package String;

public class 문자열_내_p와y의_개수 {
    class Solution {
        boolean solution(String s) {
            s = s.toLowerCase();
            int len = s.length();

            s = s.replace("p", "");
            int p_len = len-s.length();

            len = s.length();

            s = s.replace("y", "");
            int y_len = len-s.length();

            return (p_len==y_len)?true:false;
        }
    }
}
