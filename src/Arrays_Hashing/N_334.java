package Arrays_Hashing;

public class N_334 {
    public static void main(String[] args) {
        int [] nums = new int[]{2,4,-2,-3};

        int fMin = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE;

        for(int num: nums){
            if(num<=fMin){
                fMin=num;
            }
            else if(num<=sMin){
                sMin=num;
            }
            else{
                System.out.println(true);
                return;
            }
        }
    }
    /** 반례: idx는 연속이 아니어도 됨
    public static void main(String[] args) {
        int [] nums = new int[]{2,1,5,0,4,6};
        if(nums.length < 3) {
            System.out.println(false);
        }
        for(int i=0;i<nums.length-2;i++){
            int first = nums[i];
            int mid = nums[i+1];
            int end = nums[i+2];
            if(first>mid || mid>end){
                continue;
            }
            else{
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
        return;
    }
    */
}
