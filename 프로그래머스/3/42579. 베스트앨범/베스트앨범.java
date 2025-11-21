import java.util.*;
class Solution {
    static class Song{
        int total;
        int idx;
        public Song(int total, int idx){
            this.total = total;
            this.idx = idx;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String,PriorityQueue<Song>> map = new HashMap<>();        
        Map<String, Integer> play = new HashMap<>();    
        
        for(int i=0;i<genres.length;i++){
            String g = genres[i];
            map.putIfAbsent(g, new PriorityQueue<>((a,b)->{
                if(a.total == b.total) return Integer.compare(a.idx, b.idx);
                return Integer.compare(b.total, a.total);
            }));
            map.get(g).offer(new Song(plays[i], i));
            play.put(g, play.getOrDefault(g, 0)+plays[i]);
        }
       PriorityQueue<Map.Entry<String, Integer>> pq =new PriorityQueue<>((a,b)->{
           return b.getValue()-a.getValue();
       });
        pq.addAll(play.entrySet());
        List<Integer> answer =new ArrayList<>();        
        while(!pq.isEmpty()){
            String key = pq.poll().getKey();
            PriorityQueue<Song> songs = map.get(key);
            int count =0;
            while(!songs.isEmpty() && count <2){
                answer.add(songs.poll().idx);
                count++;
            } 
        }
        return answer.stream().mapToInt(i->i).toArray();
        
    }
}