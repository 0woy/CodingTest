package BruteForce;

public class 카펫 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown+yellow;
        int max = (int)Math.sqrt(total);

        for(int i=max;i>2;i--){
            // 나누어 떨어지는 경우만 진행
            if(total%i==0){
                int row = total/i;
                int col = i;
                if((row-2)*(col-2)==yellow){
                    return new int[]{row,col};
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        solution(brown,yellow);
    }
}
