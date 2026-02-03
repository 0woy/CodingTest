import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            list = new ArrayList<>();
            sb.append("#" + t + " ");
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) list.add(Integer.parseInt(st.nextToken()));   // 원본
            br.readLine();

            st = new StringTokenizer(br.readLine(), "I");
            while (st.hasMoreTokens()) {
                String[] cmd = st.nextToken().trim().split(" ");
                int pos = Integer.parseInt(cmd[0]);
                int count = Integer.parseInt(cmd[1]);
                if(pos > 10) continue;
                List<Integer> collect = Arrays.stream(cmd)
                        .skip(2)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                list.addAll(pos, collect);
            }
            for(int i=0;i<10;i++)sb.append(list.get(i)+" ");

            sb.append("\n");


        }
        System.out.println(sb);
    }
}