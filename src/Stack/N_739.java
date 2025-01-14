package Stack;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/*
Given an array of integers temperatures represents the daily temperatures,
return an array answer such that answer[i] is the number of days
you have to wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
class Value{
    int value;
    int idx;

    public Value(int value, int idx){
        this.value = value;
        this.idx = idx;
    }

}
public class N_739 {
    /** First Solution (ft. Value Class)
    static class Value{
        int idx;
        int value;
        int next;
        public Value(){}
        public Value(int idx, int value){
            this.idx = idx;
            this.value = value;
            this.next =0;
        }
        public void setNext(int next){
            this.next= next;
        }
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Value> stack = new Stack<>();
        int [] answer = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            if(stack.size()>0){
                if(temperatures[i]>stack.peek().value){
                    while(stack.size()>0&&stack.peek().value<temperatures[i]){
                        Value top = stack.pop();
                        top.setNext(i);
                        answer[top.idx] = top.next;
                    }
                }
            }
            stack.push(new Value(i, temperatures[i]));
        }

        while(stack.size()>0){
            Value remain = stack.pop();
            answer[remain.idx] = remain.next;
        }

        for(int i=0;i<answer.length;i++){
            if(answer[i]==0){
                continue;
            }
            else{
                answer[i] = Math.abs(i-answer[i]);
            }
        }

        for(int i: answer){
            System.out.print(i+" ");
        }
        return answer;
    }
     */
    /** Previous Solution
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int [] answer =new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int idx = stack.pop();
                answer[idx] = i -idx;
            }

                stack.push(i);
        }
        for(int i: answer){
            System.out.print(i+" ");
        }
        return answer;
    }
    public static void main(String[] args) {
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});

    }
     */

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            int cur = temperatures[i];
            while (!stack.isEmpty() && cur>temperatures[stack.peek()]){
                int idx = stack.pop();
                res[idx] = i-idx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        for(int v: res){
            System.out.print(v+" ");
        }
        return res;
    }
    public static void main(String[] args) {
        int [] temperatiure =new int[]{73,74,75,71,69,72,76,73};
        dailyTemperatures(temperatiure);
    }
}
