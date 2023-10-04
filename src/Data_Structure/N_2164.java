package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class N_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> deque = new LinkedList<Integer>();
        // idx 0 = n, idx n: 1
        for(int i=n;i>0;i--)
            deque.addLast(i);
        while(true){
            if(deque.size() == 1) break;

            deque.removeLast();
            int temp = deque.removeLast();
            deque.addFirst(temp);
        }
        System.out.println(deque.pop());

    }

}
