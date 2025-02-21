package Arrays_Hashing;

public class N_3456 {
    /** My SOLVE
    public static boolean hasSpecialSubstring(String s, int k) {
        int len = k;
        char start = s.charAt(0);

        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(start==cur){
                len--;
                if(len==0) {
                    if (i == s.length() - 1) {
                        return true;
                    }else{
                        if(s.charAt(i+1)==cur){
                            int j =i;
                            while (j<s.length() &&s.charAt(j)==cur){
                                j++;
                            }
                            i=j-1;
                            start =cur;
                            len = k;
                        }
                        else{
                            return true;
                        }
                    }
                }
            }else{
                start=cur;
                len = k;
                i-=1;
            }
        }
        return false;
    }
     */
    public static boolean hasSpecialSubstring(String s, int k) {
        int len = s.length();
        int i=0;
        for(int j=0;j<s.length();j++){
            if(s.charAt(i)==s.charAt(j)) continue;
            if (j-i==k)return true;
            i=j;
        }
        return (len-i)==k;
    }

    public static void main(String[] args) {
        String s= "ccc";
        int k = 2;
        hasSpecialSubstring(s, k);
    }
}
