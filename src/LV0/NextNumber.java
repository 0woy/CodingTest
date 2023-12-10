package LV0;
/*
1. 등비수열 (첫 항:a, 공비: r)
- n번째 항 = a * r^(n-1)

-공비에 따른 특징
i) r>0: 모든 부호가 첫 항의 부호와 동일
ii) r<0: 모든 부호가 번갈아 가며 나타남
iii) r==1: 모든 항, 부호 동일
iv) r==-1: 모든 항 동일, 부호 번갈아 나타남

- 등비 중항
a b c가 등비수열을 이룬 경우 b^2 =ac;

2. 등차수열
- 등차:  a2-a1;
 */

public class NextNumber {

    public static int solution(int[] common) {
        int length = common.length;
        int answer = 0;
        
        // 등비수열인 경우
        if((int)Math.pow(common[1],2) == common[0]*common[2]) {
            if (common[0] == 0)
                answer = 0;
            else {
                int r = common[1] / common[0];    // 공비 구하기
                answer = common[0] * ((int) Math.pow(r, length));   // n번째 수 구하기
            }
        }

        // 등차수열인 경우
        else{
            int d = common[2] - common[1];
            answer = common[0]+length*d;
        }
        return answer;
    }

    public static void main(String[] args) {
        // TestCase
        int[] tmp = {1,2,3,4};
        System.out.println(solution(tmp));

        tmp = new int[]{2,4,8};
        System.out.println(solution(tmp));

    }
}
