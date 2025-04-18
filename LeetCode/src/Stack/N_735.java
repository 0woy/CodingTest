package Stack;

import java.util.*;

public class N_735 {
    /** T: O(N), S:O(N+N)
    static List<Integer> list;
    // 음수 저장
    public static int addMinus(int idx, int[] asteroids){
        while (idx<asteroids.length && asteroids[idx]<0){
            list.add(asteroids[idx++]);
        }
        return idx;
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> queue = new ArrayDeque<>();
        list = new ArrayList<>();
        int idx = 0;
        // 처음 양수 찾기
        idx =addMinus(idx,asteroids);
        while (idx < asteroids.length) {

            // 다음 음수 까지 stack에 양수 list 저장
            while (idx<asteroids.length &&  asteroids[idx] > 0) {
                queue.addFirst(asteroids[idx++]);
            }
            if(idx>=asteroids.length) break;
            int cur = asteroids[idx] *-1;
            // 양 음 이므로 stack vs 음수
            while (!queue.isEmpty()) {
                int plus = queue.pop();
                if(plus==cur){
                    idx++;
                    break;
                }
                else if(plus>cur){
                    idx++;
                    queue.addFirst(plus);
                    break;}

            }
            if(queue.isEmpty()){
               idx=addMinus(idx,asteroids);
            }
        }
        while (!queue.isEmpty()) {
            list.add(queue.pollLast());
        }
        return list != null ? list.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
*/

    // T: O(N), S:O(N)
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a :asteroids){
            if(a>0){
                stack.push(a);
            }else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<-a){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek()<0){
                    stack.push(a);
                }
                if(stack.peek()==-a){
                    stack.pop();
                }
            }
        }
        int [] res = new int[stack.size()];
        int idx = res.length-1;
        while(!stack.isEmpty()){
            res[idx--] = stack.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,-1,-2};
        asteroidCollision(nums);

    }
}
