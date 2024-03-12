package String;

public class 이진_변환_반복하기 {
    class Solution {
        public int[] solution(String s) {
            StringBuilder sb;
            int z_count =0;
            int count =0;
            while(true){
                count++;
                sb= new StringBuilder();
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)=='0') z_count++;
                    else sb.append(1);
                }
                if(sb.length()==1) break;
                s = Integer.toString(sb.length(),2);
            }

            int[] answer = {count,z_count};
            return answer;
        }
    }
}
