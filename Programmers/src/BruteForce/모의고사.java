package BruteForce;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class 모의고사 {
    private static int[][] person;
    public static boolean isCorrect(int idx,int submit, int answer){
        return person[idx][submit]==answer;
    }
    public static int[] solution(int[] answers) {
        HashMap<Integer,Integer> score = new HashMap<>();
        for(int i=0;i<answers.length;i++){
            for(int p=0;p<person.length;p++){
                if(isCorrect(p, i%person[p].length, answers[i])){
                    score.put(p+1,score.getOrDefault(p+1,0)+1);
                }
            }
        }
        int max = 0;
        for(int val: score.values()){
            max = Math.max(max, val);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int key: score.keySet()){
            if(score.getOrDefault(key, -1)==max){
                list.add(key);
            }
        }
        int[] answer =new int[list.size()];
        int idx =0;
        for(int val: list){
            answer[idx++] = val;
        }
        return answer;
    }
    public static void main(String[] args) {
        int [] answer = new int[]{1,3,2,4,2};
        person = new int[][]{
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        solution(answer);
    }
}
