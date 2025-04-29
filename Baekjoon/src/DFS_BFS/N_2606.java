package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제 설명
 1번 컴퓨터에 바이러스가 감염된 경우,
 1번 컴퓨터로 인해 바이러스에 걸리는 컴퓨터 개수 반환

 시간 복잡도
 내 생각: O(N+K) ✨
 
 풀이
 1번부터 BFS를 순회하면서 방문 가능한 정점을 QUE에 삽입하면서 count를 증가함.
 순회가 끝나면, count를 반환
 */
public class N_2606 {
    /** Wrong
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, List<Integer>> map = new HashMap<>();

        int com = Integer.parseInt(br.readLine());
        int connect = Integer.parseInt(br.readLine());

        while(connect >0){
            connect--;
            st = new StringTokenizer(br.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end =Integer.parseInt(st.nextToken());

            if(end < start){
                int tmp = end;
                end = start;
                start = tmp;
            }
            if(!map.containsKey(start)){
                map.put(start, new ArrayList<>());
            }
            map.get(start).add(end);
        }
        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        int count =0;
        while(!que.isEmpty()){
            int next =que.poll();
            for(int v: map.getOrDefault(next,new ArrayList<>())){
                que.add(v);
                count++;
            }
        }
        System.out.println(count);
    }
     */
    /** Previous Solve
    public static void insert(Map<Integer, List<Integer>> map, int s, int e){
        if(!map.containsKey(s)){
            map.put(s, new ArrayList<>());
        }
        if(!map.containsKey(e)) {
            map.put(e, new ArrayList<>());
        }
            map.get(s).add(e);
            map.get(e).add(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int con = Integer.parseInt(br.readLine());
        boolean [] visited = new boolean[n+1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (con > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            insert(map,s,e);
            con--;
        }
        int virus = 0;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        visited[1]=true;
        while(!que.isEmpty()){
            int key = que.poll();
            if(!map.containsKey(key)){continue;}
            for(int i: map.get(key)){
                if(visited[i]){
                    continue;
                }
                visited[i] = true;
                que.add(i);
                virus++;
            }
        }
        System.out.println(virus);
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        List<List<Integer>> list =new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
        System.out.println(bfs(1, list));

    }

    public static int bfs(int start, List<List<Integer>> list){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[list.size()];
        queue.add(start);
        visited[start] = true;
        int count =0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int i : list.get(cur)){
                if(!visited[i]){
                    queue.add(i);
                    count ++;
                    visited[i] = true;
                }
            }
        }

        return count;
    }
}
