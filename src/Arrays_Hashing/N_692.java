package Arrays_Hashing;

import java.util.*;


public class N_692 {
    public static void main(String[] args) {
        String [] words = new String[]{"i","love","leetcode","i","love","coding"};
        int k=2;
        /** Map, 1 List (Collection)
        Map<String, Integer> map =new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        List<String> answer = new ArrayList<>(map.keySet());
        Collections.sort(answer,
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                      if(map.get(o1)!=map.get(o2)){
                          return map.get(o2)-map.get(o1);
                      }
                      else{
                          return o1.compareTo(o2);
                      }
                    }
                }
        );
        System.out.println(answer.subList(0,k));
         */
        /** Map, pq
         * Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> mq =
                new PriorityQueue<>(
                        new Comparator<Map.Entry<String, Integer>>() {
                            @Override
                            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                                if(o1.getValue() != o2.getValue()){
                                    return o1.getValue()-o2.getValue();
                                }
                                else{
                                    return o2.getKey().compareTo(o1.getKey());
                                }
                            }
                        }
                );

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            mq.offer(entry);
            if(mq.size() > k){
                mq.poll();
            }
        }

        List<String> answer= new ArrayList<>();
        while(!mq.isEmpty()){
            answer.add(0,mq.poll().getKey());
        }
        System.out.println(answer.toString());
         */
        /** Map, 2 List

        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        List<Map.Entry<String, Integer>> sortMap = new LinkedList<>(map.entrySet());
        sortMap.sort(((o1, o2) -> {
            if(o1.getValue() != o2.getValue()){
                return o2.getValue()-o1.getValue();
            }
            else{
                return o1.getKey().compareTo(o2.getKey());
            }
        })
        );
        List<String> answer = new LinkedList<>();
        for(Map.Entry<String, Integer> entry: sortMap.subList(0,k)){
            answer.add(entry.getKey());
        }
        System.out.println(answer.toString());

         */
    }
}