import java.util.*;
public class MaxMin
{
    public static void main(String []  args){
        Scanner scanner = new Scanner(System.in);
        int count;
        count = scanner.nextInt();
        int v [] = new int [count];
        for(int i=0;i< count;i++) {
            v[i] = scanner.nextInt();
        }
        int max=v[0], min=v[0];

        for(int i=0;i<count;i++){
         if(max < v[i]) max = v[i];
         if(min>v[i])   min =v[i];
        }
        System.out.print(min+" "+max);
    }

}
