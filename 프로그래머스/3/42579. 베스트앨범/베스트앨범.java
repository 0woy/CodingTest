import java.util.*;

class Solution {
    static class Song {
        int idx;
        int play;
        Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalMap = new HashMap<>();  
        Map<String, PriorityQueue<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
            songMap.putIfAbsent(genres[i],
                    new PriorityQueue<>((a, b) -> {
                        if (a.play == b.play) return a.idx - b.idx;
                        return b.play - a.play;
                    })
            );

            songMap.get(genres[i]).add(new Song(i, plays[i]));
        }

        // 장르를 총 재생수 기준으로 정렬
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(totalMap.entrySet());

        List<Integer> answer = new ArrayList<>();

        // 장르별 2개씩 뽑기
        while (!pq.isEmpty()) {
            String genre = pq.poll().getKey();
            PriorityQueue<Song> q = songMap.get(genre);

            int count = 0;
            while (!q.isEmpty() && count < 2) {
                answer.add(q.poll().idx);
                count++;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
