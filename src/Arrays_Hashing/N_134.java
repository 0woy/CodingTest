package Arrays_Hashing;

public class N_134 {
    /** first Try
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int c_gas = 0;
        for(int i=start;i<cost.length+start;){
            int idx = i%cost.length;
            c_gas +=gas[idx];
            // 운행 불가
            if(c_gas<cost[idx]){
                c_gas=0;
                start++;
                if(start>=cost.length){
                    return  -1;
                }
                i = start;
            }
            else{
                i++;
                c_gas-=cost[idx];
            }
        }
        return start;
    }
     */
    /** second Try
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int c_gas = 0;
        boolean recur = false;
        for(int i=start;i<cost.length+start;){
            int idx = i%cost.length;
            // 운행 불가
            if(c_gas+gas[idx]<cost[idx]){
                c_gas=0;
                if(recur || idx+1 == start){
                    return -1;
                }
                start = idx+1;
                if(start >= cost.length-1){
                    recur= true;
                }
                i = start;
            }
            else{
                c_gas+=gas[idx]-cost[idx];
                i++;
            }
        }
        return start;
    }
     */

    public static boolean isValidTotals(int [] gas, int[] cost){
        int n = gas.length;
        int t_gas = 0;
        int t_cost = 0;
        for(int i=0;i<n;i++){
            t_gas += gas[i];
            t_cost += cost[i];
        }
        return t_gas>=t_cost;
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start =0;
        int n = gas.length;
        if(isValidTotals(gas, cost)){
            int c_gas = 0;
            for(int i = start;i<n+start;){
                c_gas += gas[i%n];
                if(c_gas<cost[i%n]){
                    start = (i+1)%n;    // 처음 부터 끝까지 순회 완료
                    i=start;
                    c_gas=0;
                }
                else {
                    c_gas -=cost[i%n];
                    i++;
                }
            }
        }
        else{
            return -1;
        }
        return start;
    }
    public static void main(String[] args) {
        int [] gas = new int[]{1,2,3,4,5};
        int [] cost = new int[]{3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }
}
