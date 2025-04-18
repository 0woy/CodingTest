package String;

public class 이진_변환_반복하기 {
    class Solution {
        private int countZero(String s){
            int zero =0;
            for( char c : s.toCharArray()){
                if(c == '0') zero++;
            }
            return zero;
        }
        public int[] solution(String s) {
            int z_count =0;
            int count =0;
            while(!s.equals("1")){
                int zeros = countZero(s);
                count++;
                z_count += zeros;
                int one = s.length() - zeros;
                s=  Integer.toString(one, 2);
            }

            return new int[]{count,z_count};
        }
    }
}
