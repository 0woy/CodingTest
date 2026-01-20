import java.util.*;

class Solution {
    static int total;
    static String[] answer;
    static String[] paper;
    static class Country {
        String name;
        boolean visited;

        public Country(String name) {
            this.name = name;
            this.visited = false;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Country country = (Country) o;
            return (visited == country.visited) && Objects.equals(name, country.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name,visited);
        }
    }
    public String[] solution(String[][] tickets) {
        total = tickets.length+1;
        Map<String, List<Country>> map = new HashMap<>();
        int idx =0;
        for(String[] ticket: tickets){
            String key = ticket[0];
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new Country(ticket[1]));
        }
        for(String key: map.keySet()){
            Collections.sort(map.get(key), (o1, o2)-> o1.name.compareTo(o2.name));
        }
        
        paper=new String[total];
        
        dfs(map, 1, "ICN");
        return answer;
    }
    
    static boolean dfs(Map<String, List<Country>> map, int count, String cur){
        if(count == total){
            answer = new String[paper.length];          
            System.arraycopy(paper, 0, answer, 0, paper.length);
            answer[0]="ICN";
            return true;
        }
        
        List<Country> neighbors = map.getOrDefault(cur, new ArrayList<>());
        
        for(Country nei: neighbors){
            if(!nei.visited){
                nei.visited = true;
                paper[count] = nei.name;
                if(dfs(map, count+1, nei.name)) return true;
                nei.visited = false;
            }
        }
        return false;
    }
}


/**
total = tickets.len

map<s, lIST<s>>
dfs(a){
    ...
}
a -> b, c


*/