package TwoPointers;

public class N_443 {

    public static void addChars(char[] chars, char current, int count, int alpha){
        chars[alpha++] = current;
        if(count>1){
            String nums = String.valueOf(count);
            for(char n: nums.toCharArray()){
                chars[alpha++]=n;
            }
        }
    }
    public static int compress(char[] chars) {
        char current = chars[0];
        int count =1;
        int alpha =0;
        for(int i=1;i<chars.length;i++){
            if(current == chars[i]){
                count++;
            }
            else{
                addChars(chars, current,count,alpha);
                current = chars[i];
                count=1;
            }
        }
        addChars(chars, current,count,alpha);
        return alpha;
    }

    public static void main(String[] args) {
        char [] chars = new char[]{'a','a','b','b','c','c','c'};
        compress(chars);
    }
}
