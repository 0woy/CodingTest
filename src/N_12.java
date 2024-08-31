import java.util.HashMap;
import java.util.StringTokenizer;

public class N_12{
    public static HashMap<Integer, String > map;
    public static void initMap(){
        map = new HashMap<>();
        StringTokenizer str = new StringTokenizer("I V X L C D M", " ");
        StringTokenizer nums = new StringTokenizer("1 5 10 50 100 500 1000", " ");
        while(str.hasMoreTokens()){
            map.put(Integer.parseInt(nums.nextToken()), str.nextToken());
        }
    }
    /** First Try: NOT Deep Thinking
    public static String intToRoman(int num) {
        initMap();
        StringBuilder sb =new StringBuilder();
        StringBuilder result =new StringBuilder();
        // 3749 -> num/10 = 374, nums%10 = 9;
        int pos = 1;
        while(num!=0){
            int cur =num%10; // 9
            if(cur == 9){
                // pos가 1이니까 10을 찾아야 함, 2이면 100
                sb.append(map.get((int)Math.pow(10,pos-1)));
                sb.append(map.get((int)Math.pow(10,pos)));

            }
            else if(cur == 4){

                // pos가 1이면 5와 1을 찾아야함, 2인경우 50과 10
                sb.append(map.get((int)Math.pow(10,pos-1)));
                sb.append(map.get((int)(Math.pow(10,pos)-5*Math.pow(10,pos-1))));
            }
            else{
                if(cur >= 5){
                    //700, pos = 3
                    int key = (int) (5*Math.pow(10,pos-1));
                    sb.append(map.get(key));
                    cur -=5;
                }
                while(cur>0){
                    int key = (int) (Math.pow(10,pos-1));
                    sb.append(map.get(key));
                    cur --;
                }
            }
            pos++;
            result.insert(0,sb);
            sb.setLength(0);
            num /=10;
        }
        System.out.println(result.toString());

        return result.toString();
    }
     */
    public static String intToRoman(int num) {
        initMap();
        StringBuilder sb = new StringBuilder();
        int len = String.valueOf(num).length()-1; //len <=4 4인경우 1000의 자리
        while(num!=0){
            int pos = (int)Math.pow(10,len);
            int cur = num/pos; //3, pos = 1000
            if(cur == 9){
                sb.append(map.get(pos));
                sb.append(map.get(pos*10));
            }
            else if(cur == 4){
                // 3490, pos = 100+500
                sb.append(map.get(pos));
                sb.append(map.get(pos*5));
            }
            else{
                if(cur >= 5){
                    // 3749 pos = 100, 500+100+100
                    sb.append(map.get(pos*5));
                    cur-=5;
                }
                while(cur>0){
                    sb.append(map.get(pos));
                    cur--;
                }
            }
            len --;
            num %=pos;
        }
        System.out.println(sb.toString());
        return sb.toString();

    }
    public static void main(String[] args) {
        int num = 3749;
        intToRoman(num);
    }
}
