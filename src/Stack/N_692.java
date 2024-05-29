package Stack;

import java.util.*;

public class N_692 {
    public static void main(String[] args) {
        String [] words = new String[]{"is","day","the","sunny","the","the","the","sunny","is","is"};
        int k=4;
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        List<Map.Entry<String, Integer>> sortMap = new LinkedList<>(map.entrySet());
        sortMap.sort(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o1.getValue()!=o2.getValue()) return o2.getValue()-o1.getValue();
                        else if(o1.getValue()==o2.getValue())
                            return o1.getKey().compareTo(o2.getKey());
                        return -1;
                    }
                }
        );
        List<String> answer = new LinkedList<>();
        int idx = 0;
        while(idx<k){
            answer.add(sortMap.get(idx++).getKey());
        }

        System.out.println(answer.toString());
    }
}
