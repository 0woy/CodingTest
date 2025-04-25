package DFS_BFS;
import java.util.*;

public class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;
        return bfs(begin, target, words);
    }
    public static int bfs(String begin, String target, String[] words){
        Set<String> visited = new HashSet<>();
        Queue<String> que = new ArrayDeque<>();
        que.add(begin);
        visited.add(begin);
        int depth=0;
        while(!que.isEmpty()){
            int len = que.size();
            for(int i=0;i<len;i++){
                String next = que.poll();
                if(next.equals(target)) return depth;
                for(String diff : words){
                    if(!visited.contains(diff) && isChange(next, diff)){
                        que.add(diff);
                        visited.add(diff);
                    }
                }
            }
            depth++;
        }
        return 0;
    }
    public static boolean isChange(String a, String b){
        int diffCount =0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diffCount++;
                if(diffCount >1) return false;
            }
        }
        return true;
    }
}
