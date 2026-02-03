import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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
            for (int i = 0; i < n; i++) list.add(Integer.parseInt(st.nextToken()));   // 원본
            br.readLine();

            String [] cmds = br.readLine().split(" ");

            for(int i=0;i<cmds.length;){
                String cmd = cmds[i++];
                int pos = Integer.parseInt(cmds[i++]);
                int count = Integer.parseInt(cmds[i++]);

                if(cmd.equals("I")){
                    List<Integer> collect = Arrays.stream(Arrays.copyOfRange(cmds, i, i + count))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    list.addAll(pos, collect);
                    i+=count;
                }else{
                    for(int c=0;c<count;c++){
                        list.remove(pos);
                    }
                }
            }
            for (int i = 0; i < 10; i++) sb.append(list.get(i) + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}