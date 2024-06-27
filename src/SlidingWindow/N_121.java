package SlidingWindow;

public class N_121 {
    public static void main(String[] args) {
        int[] prices =  new int[]{7,3,2,5,6,1,4};
        int maxStock =0;
        int buyPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            if(buyPrice<prices[i]){
                maxStock = Math.max(prices[i]-buyPrice, maxStock);
            }
            else{
                buyPrice = prices[i];
            }
        }
        System.out.println(maxStock);
    }
}
