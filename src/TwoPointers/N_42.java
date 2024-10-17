package TwoPointers;

public class N_42 {
    public static int water;
    public static int calc(int max, int height){
        if(max> height){
            water+= max -height;
            return  max;
        }
        else{
            return height;
        }
    }
    public static int trap(int[] height) {
        water =0;
        int lm = height[0];
        int right = height.length-1,left =0;
        int rm = height[right];

        while(left<right){
            if(lm<=rm){
                left++;
                lm = calc(lm, height[left]);
            }
            else{
                right--;
               rm =calc(rm, height[right]);
            }
        }
        return water;

    }
    public static void main(String[] args) {
        int[]height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        trap(height);

    }
}
