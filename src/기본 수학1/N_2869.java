import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2869 {
    /** Previous Solve
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int day = 0;
        day = (goal - down) / (up - down);
        if ((goal - down) % (up - down) != 0)
            day++;
        System.out.print(day);
    }
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        height -= up;
        int day = 1;
        if(height == 0){
            System.out.println(day);
            return;
        }
        day = height/(up-down);
        if(height%(up-down)>0){
            day++;
        }
        day++;
        /** TimeOut
        int day =1;
        while(height>0){
            height -= up;
            if(height<=0){ break;}
            height +=down;
            day++;
        }
         */

        System.out.println(day);

    }
}

