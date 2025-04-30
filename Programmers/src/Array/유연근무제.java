package Array;

public class 유연근무제 {
    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        for(int i=0;i<schedules.length;i++){
            int limit = schedules[i]+10;
            if((limit%100)/60==1){
                limit +=40;
            }

            int day = startday;
            for(int t: timelogs[i]){
                if(day % 7 ==0 || day % 7 == 6){
                    day ++;
                    continue;
                }
                if(t>limit){
                    answer--;
                    break;
                }
                day++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] schedules = new int[]{700, 800, 1100};
        int [][] timelogs = new int[][]{
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
        };
        System.out.println(solution(schedules, timelogs, 5));
    }
}

