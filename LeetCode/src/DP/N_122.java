package DP;

public class N_122 {
    /** first Try
    public static int maxProfit(int[] prices) {
        int max =0;
        int cur,next,prev= prices.length;
        for(int i=0;i<prices.length;i++){
            cur = prices[i];
            for(int j=i+1;j<prices.length;j++){
                next = prices[j];
                if(cur >= next){
                    break;
                }
                else{
                    // 새로운 매도 매수가 이루어진 경우
                    if(prev<i){
                        max += next-cur;
                        prev = next;
                    }
                    // 기존에서 비교하는 경우
                    else{
                        if(max < next -cur){
                            max = next-cur;
                        }
                        else{
                            i=j-1;
                            prev = j-1;
                            break;
                        }
                    }
                }
            }
        }
        return  max;
    }
     */
    /** Second Try
    public static int maxProfit(int[] prices) {
        int max = 0;
        int cur, next,before=prices.length;
        for(int i=0;i<prices.length;i++){
            cur = prices[i];
            for(int j=i+1;j<prices.length;j++){
                next = prices[j];
                if(cur>=next){
                    before = j;
                    break;
                }
                int price = next-cur;
                if(before<i){
                    max +=price;
                    before++;
                    continue;
                }
                if(max > price){
                    before = j-1;
                    i=j-1;
                    break;
                }
                max =Math.max(max, price);
            }
        }
        System.out.println(max);
        return max;
    }
     */

    public static int maxProfit(int[] prices) {
        int max =0;
        int cur = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>cur){
                max += prices[i]-cur;
            }
            cur = prices[i];
        }
        return max;
    }
    public static void main(String[] args) {
        int [] prices = new int[]{7,6,4,3,1};
        maxProfit(prices);
    }

}
