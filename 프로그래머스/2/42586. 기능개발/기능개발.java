import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> stack =new ArrayDeque<>();
        for(int p: progresses){
            stack.addLast(p);
        }
        List<Integer> answer= new ArrayList<>();
        int i=0;
        while(!stack.isEmpty()){
            int count=1;
            int prev = stack.removeFirst();
            int rest = 100-prev;
            int days = rest/speeds[i]+((rest%speeds[i]>0)?1:0);
            System.out.println("days: "+days+", prev: "+prev);
            i++;
            while(!stack.isEmpty() && stack.peekFirst()+speeds[i]*days >=100){
                int tmp = stack.remove();
                System.out.println("제거: "+tmp);
                i++;
                count++;
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}


/**
progresses 순서대로 100%가 완성돼야 반영 ok
if) 93, 30, 55 / 2 30 5 인 경우,
100-93 = 7, 필요한 양을 속도로 나눈 몫 (개발 소요일) 나머지가 있다면 +1
93 -> top 
30
55
i=0;
rest = 100-top, days = rest/speeds[i] + rest%speeds[i]>0?1:0;
while(!stack.isEmpty() && stack[top]+days*speeds[i] >= 100) pop()
*/