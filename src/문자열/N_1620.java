import javax.management.StringValueExp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1620 {
    /** TimeOut
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        ArrayList<String> pocketmon = new ArrayList<>();
        while(n>0){
            pocketmon.add(br.readLine());
            n--;
        }
        while(q>0){
            String que = br.readLine();
            try{
                int num = Integer.parseInt(que);
                sb.append(pocketmon.get(num));
            }catch (NumberFormatException e){
                sb.append(pocketmon.indexOf(que)+1);
            }
            sb.append("\n");
            q--;
        }
        System.out.print(sb.toString());
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int idx =1;
        while(n > 0){
            String name = br.readLine();
            map.put(name, idx++);
            list.add(name);
            n--;
        }
        while(m > 0){
            String find = br.readLine();
            try{
                int pos = Integer.parseInt(find);
                sb.append(list.get(pos-1));
            }catch (NumberFormatException e){
                sb.append(map.get(find));
            }
            sb.append("\n");
            m--;
        }
        System.out.print(sb.toString());
    }
}
