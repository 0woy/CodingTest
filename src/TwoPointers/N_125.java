package TwoPointers;

public class N_125 {
    public static void main(String[] args) {
        String s ="a";
        s = s.replaceAll("[^a-zA-Z0-9]","");
        s =s.toLowerCase();

        int front = 0, end =s.length()-1;
        while(front<=end){
            if(s.charAt(front++)!=s.charAt(end--)) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
        return;
    }
}
