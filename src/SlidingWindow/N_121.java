package SlidingWindow;

public class N_121 {
    public static void main(String[] args) {
        int[] prices =  new int[]{7,3,2,5,6,1,4};
        int stock = 0;
        int min = prices[0];
        int max = -1;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min  = prices[i];
                max = -1;
                continue;
            }
            if(max < prices[i]){
                max = prices[i];
            }
            if(max != -1){
                stock = stock<max-min?max-min:stock;
            }
        }
        System.out.println(stock);
    }
}
