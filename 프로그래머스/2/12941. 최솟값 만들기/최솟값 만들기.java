import java.util.*;
class Solution
{    
    public int solution(int []A, int []B){
        //정렬을 갈겨서  int af, bf, al, bl
        Arrays.sort(A);
        Arrays.sort(B);
        int af=0;
        int bf =0;
        int al = A.length-1;
        int bl = B.length-1;
        int total =0;
        while(af <= al && bf <= bl){
            if(A[al] > B[bl]){
                total += B[bl--] * A[af++];                
            }else{
                total += A[al--] * B[bf++];
            }
        }
        
        
        return total;
    }
}