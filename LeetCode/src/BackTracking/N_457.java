package BackTracking;

public class N_457 {
    /** Wrong Answer
    static int [] visited;
    public static boolean dfs(int cur, int[] nums, int count){
        if(visited[cur]==1 && count >=2) return true;
        if(visited[cur]==2) return false;

        visited[cur]=1; // 탐색 중

        int next =nums[cur];
        if(cur*next>0) {
            if (next != cur && dfs(next, nums, count + 1)) {
                return true;
            }
        }
        visited[cur]=2; // 탐색 완료

        return false;
    }
    public static boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        visited = new int[len];
        for(int i=0;i<len;i++){
            if(visited[i]==0){
                if(dfs(i, nums, -1)){
                    return true;
                }
            }
        }
        return false;
    }*/
    static boolean[] visited;
    static boolean isCycle;
    public static void dfs(int cur, int[] nums, int dir, int depth){
        if(visited[cur]){
            if(depth>1){ isCycle=true;}
            return;
        }

        visited[cur]=true;
        int step = nums[cur];
        if(step *dir<0){return;}    // 방향이 다른 경우

        int next = (cur+step)%nums.length;
        if(next < 0){
            next+=nums.length;
        }
        if(next==cur){  // 자기 자신으로 돌아올 경우
            return;
        }
        dfs(next, nums, dir, depth+1);
    }
    public static boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        isCycle = false;
        for (int i = 0; i < len; i++) {
            visited = new boolean[len];
            dfs(i,nums, nums[i],0);
            if(isCycle){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [] nums = new int[]{2,-1,1,2,2};
        System.out.println(circularArrayLoop(nums));
    }
}
