package String;

public class 문자열_내_p와y의_개수 {
    class Solution {
        boolean solution(String s) {
            s= s.toLowerCase();
            int p_len = s.length() - s.replace("p","").length();
            int y_len = s.length() - s.replace("y","").length();
            return p_len == y_len;
        }
    }
}
