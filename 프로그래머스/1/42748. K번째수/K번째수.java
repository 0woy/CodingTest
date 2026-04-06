import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int [] answer = new int[commands.length];
        int i =0;
        for(int [] command : commands){
            int s = command[0];
            int e = command[1];
            int idx = command[2];
            
            int [] calc = Arrays.copyOfRange(array, s-1,e);
            Arrays.sort(calc);            
            answer[i++] = calc[idx-1];
            
        }
        return answer;
    }
}

/**
i, i+1. sort


*/