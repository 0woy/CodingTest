package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
학기가 끝나고, 학생들의 점수로 학점을 계산중이다.
학점은 상대평가로 주어지는데, 총 10개의 평점이 있다.

학점은 학생들이 응시한 중간/기말고사 점수 결과 및 과제 점수가 반영한다.
각각 아래 비율로 반영된다.

10 개의 평점을 총점이 높은 순서대로 부여하는데,
각각의 평점은 같은 비율로 부여할 수 있다.
예를 들어, N 명의 학생이 있을 경우 N/10 명의 학생들에게 동일한 평점을 부여할 수 있다.
입력으로 각각의 학생들의 중간, 기말, 과제 점수가 주어지고,
학점을 알고싶은 K 번째 학생의 번호가 주어졌을 때,
K 번째 학생의 학점을 출력하는 프로그램을 작성하라.


[제약사항]
1. N은 항상 10의 배수이며, 10이상 100이하의 정수이다. (10 ≤ N ≤ 100)
2. K는 1 이상 N 이하의 정수이다. (1 ≤ K ≤ N)
3. K 번째 학생의 총점과 다른 학생의 총점이 동일한 경우는 입력으로 주어지지 않는다.

[입력]
10
10 2
87 59 88
99 94 78
94 86 86
99 100 99
69 76 70
76 89 96
98 95 96
74 69 60
98 84 67
85 84 91


[출력]
#1 A-
...
 */
public class N_1983 {
    public static StringTokenizer st;
    public static BufferedReader br;

    // 점수 클래스 선언
    static class Scores{
        private int middle, last, homework;
        private double total;

        public Scores(int middle,int last, int homework){
            this.middle=middle;
            this.last =last;
            this.homework=homework;
            setTotal();
        }

        public void setTotal() {
            this.total = this.middle *0.35
                    +this.last*0.45
                    +this.homework*0.2;
        }
    }

    // 성적을 입력 받아 저장하는 함수
    public static Scores[] setGrade(Scores [] scores) throws IOException {
        for(int i=0;i<scores.length;i++){
            st = new StringTokenizer(br.readLine());
            int middle = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            int homework = Integer.parseInt(st.nextToken());
            scores[i] = new Scores(middle,last,homework);

        }
        return scores;
    }

    // 찾고자 하는 k의 위치를 찾는 함수
    public static int findIdx(double find, int start, int end, Scores[]scores){
        int half = (start+end)/2;
        if(find == scores[half].total)
            return half;
        else if(find>scores[half].total){
            return findIdx(find, start, half-1,scores);
        }
        else  return findIdx(find, half+1, end,scores);
    }

    // 총점을 학점으로 변경하는 함수
    public static String ScoreToGrade(int idx, int len){
        int flag = len/10;
        if(idx/flag < 1){ return "A+";}
        else if(idx/flag<2){return "A0";}
        else if(idx/flag<3){return "A-";}
        else if(idx/flag<4){return "B+";}
        else if(idx/flag<5){return "B0";}
        else if(idx/flag<6){return "B-";}
        else if(idx/flag<7){return "C+";}
        else if(idx/flag<8){return "C0";}
        else if(idx/flag<9){return "C-";}
        else  return "D0";

    }

    public static void main(String[] args) throws IOException {
        br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=testcase;tc++){
            sb.append("#"+tc+" ");
            st = new StringTokenizer(br.readLine());
            int n =  Integer.parseInt(st.nextToken());
            int find=  Integer.parseInt(st.nextToken());

            Scores [] scores = new Scores[n];
            setGrade(scores);

            double findTotal = scores[find-1].total;

            Arrays.sort(scores, new Comparator<Scores>() {
                @Override
                public int compare(Scores o1, Scores o2) {
                    return Double.compare(o2.total,o1.total);
                }
            });
            int idx = findIdx(findTotal, 0,n,scores);
            sb.append(ScoreToGrade(idx,n)+"\n");
        }
        System.out.println(sb);

    }
}
