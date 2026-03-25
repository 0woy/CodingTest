import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        int [] num = new int[10];
        for(int i=0;i<priorities.length;i++){
            int n = priorities[i];
            que.offer(new int[]{n,i});  // 우선순위와 인덱스
            num[n]++; // 해당 우선순위 count+1;
        }
        int max = findMax(num);        
        int count =0;
        while(!que.isEmpty()){
            int [] cur = que.poll();
            if(cur[0] == max) { 
                count++;
                num[max]--;
                if(num[max]==0) max = findMax(num); // max 갱신
                if(cur[1]==location) return count;
            }else{
                que.offer(cur);
            }
        }        
        return count;
    }
    static int findMax(int [] nums){
        int max = 0;
        for(int i=9;i>=0;i--){
            if(nums[i]>0) return i;
        }
        return max;
        
    }
}

/**
0~9까지 포함된 priorities 개수 count;
현재 값이 가장 큰 값인 경우  count-1;

count가 0이 된 경우, 그 다음 큰 값 찾기 (0~9까지라 ㄱㅊ)
ArrayDeque에 삽입 삭제 반복


*/