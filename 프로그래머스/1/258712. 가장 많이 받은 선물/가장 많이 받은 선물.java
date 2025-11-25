import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> idx = new HashMap<>();
        for(int i=0;i<friends.length;i++){
            idx.put(friends[i],i);
        }
        
        int [][] cnt = new int[n][n];
        int[] give =new int[n];
        int[] take =new int[n];
        for(String gift : gifts){
            String [] list =gift.split(" ");
            
            int giver = idx.get(list[0]);
            int taker = idx.get(list[1]);
            
            cnt[giver][taker]++;
            give[giver]++;
            take[taker]++;
        }
        
        int [] giftScore =new int[n];
        for(int i=0;i<n;i++){
            giftScore[i]=give[i]-take[i];
        }
        
        int [] score = new int[n];
        for(int i=0;i<n;i++){
            taker:
            for(int j=i+1;j<n;j++){   
                if(cnt[i][j]>cnt[j][i]) score[i]++;
                else if(cnt[i][j] < cnt[j][i]) score[j]++;
                else{
                    if(giftScore[i] > giftScore[j]) score[i]++;
                    else if(giftScore[i] < giftScore[j]) score[j]++;
                }
            }
               
        }
        int answer = 0;
        for(int t: score){
            answer = Math.max(t, answer);
        }
        return answer;
    }
}