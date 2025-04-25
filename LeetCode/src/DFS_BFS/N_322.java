package DFS_BFS;

import java.util.*;

public class N_322 {
    /** dp
    public static int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int v: coins){
                if(i-v>=0){
                    dp[i] = Math.min(dp[i], dp[i-v]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
*/
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        Arrays.sort(coins);
        if(amount < coins[0]){
            return -1;
        }
        return bfs(coins, amount);
    }
    public static int bfs(int [] coins, int amount){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> que = new ArrayDeque<>();
        que.add(amount);
        visited.add(amount);
        int level=1;
        while(!que.isEmpty()){
            int len = que.size();
            while(len-- >0){
                int flag = que.poll();
                for(int v:coins){
                    int remain = flag-v;
                    if(remain==0){
                        return level;
                    }
                    if(remain>0){
                        if(!visited.contains(remain)){
                            que.add(remain);
                            visited.add(remain);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
