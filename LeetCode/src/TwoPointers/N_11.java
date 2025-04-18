package TwoPointers;

/** 문제
 * You are given an integer array height of length n.
 There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
public class N_11 {
    public static void main(String[] args) {
        int [] height = new int []{1,1};
        int max = Integer.MIN_VALUE;
        int f_idx = 0, e_idx = height.length-1;
        int width = height.length-1;
        while(f_idx<e_idx){
            int front = height[f_idx];
            int end = height[e_idx];
            int cur_height =0;
            if(front<end){
                cur_height=front;
                f_idx++;
            } else{
                cur_height=end;
                e_idx--;
            }
            int scale = width*cur_height;
            max = max < scale?scale:max;
            width--;
        }
        System.out.println(max);

    }
}
