package Arrays_Hashing;

import java.util.Arrays;

public class N_135 {
    /** Wrong [1,3,2,2,1],  Expected: 7, Output:8
    public static int candy(int[] ratings) {
        int count = ratings.length;

        for(int i=0;i<ratings.length-1;i++){
            if(ratings[i]!=ratings[i+1]){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static int candy(int[] ratings) {
        int count = ratings.length;
        if(ratings.length==1){
            return 1;
        }

        boolean isAscending = ratings[0] < ratings[1];
        int more = 0;
        for(int i=0;i<ratings.length-1;i++){
            if(ratings[i]==ratings[i+1]){
                more =0;
                continue;
            }
            if(isAscending){
                if(ratings[i]>ratings[i+1]){
                    count +=more;
                    more=0;
                    isAscending=false;
                }else{
                    more++;
                }
            }else{
                if(ratings[i]<ratings[i+1]){
                    count+=more;
                    more=0;
                    isAscending=true;
                }else{
                    more++;
                }
            }
        }
        count+=more;
        System.out.println(count);
        return count;
    }
     */

    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        //Arrays.fill(candies, 1);

        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }

        int total =ratings.length;
        for(int candy: candies){
            total+=candy+1;
        }
        return total;
    }
    public static void main(String[] args) {
        int[] ratings = new int[]{1,3,2,2,1};
        candy(ratings);
    }
}
