package Arrays_Hashing;

public class N_55 {
    public  static boolean canJump(int[] nums) {
        int goal = nums.length-1;
        for(int i=goal-1;i>=0;i--){
            if(i+nums[i]>=goal){
                goal = i;
            }
        }
        return goal==0?true:false;
    }
    public static void main(String[] args) {
        canJump(new int[]{3,2,1,0,4});
    }
}
