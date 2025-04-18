package Data_Structure;

import java.io.*;
import java.util.*;

public class N_3018 {
    /** Set: Not Solve
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int days = Integer.parseInt(br.readLine());
        Set<Integer> knowAllSongs = new HashSet<>();
        knowAllSongs.add(1);
        for(int d=0; d<days;d++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            List<Integer> participants = new ArrayList<>();
            while(st.hasMoreTokens()){
                participants.add(Integer.parseInt(st.nextToken()));
            }
            if(participants.contains(1)){
                if(d ==0){
                    knowAllSongs.addAll(participants);
                }else{
                    List<Integer> removes = new ArrayList<>();
                    for(int v: knowAllSongs){
                        if(!participants.contains(v)) {
                            removes.add(v);
                        }
                    }

                    knowAllSongs.removeAll(removes);
                }

            }else{
                boolean canShare = false;
                for(int v: participants){
                    if(knowAllSongs.contains(v)){
                        canShare=true;
                        break;
                    }
                }
                if(canShare){
                  knowAllSongs.addAll(participants);
                }
            }
        }
        List<Integer> result = new ArrayList<>(knowAllSongs);
        Collections.sort(result);
        for(int v: result){
            bw.write(v+"\n");
        }
        bw.flush();
        bw.close();
    }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int days = Integer.parseInt(br.readLine());
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int d=0;d<days;d++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            List<Integer> participants = new ArrayList<>();
            while (st.hasMoreTokens()){
                participants.add(Integer.parseInt(st.nextToken()));
            }
            if(participants.contains(1)){
                for(int p: participants){
                    Set<Integer> know = map.getOrDefault(p, new HashSet<>());
                    know.add(d);
                    map.put(p, know);
                }
            }else{
                Set<Integer> shares =new HashSet<>();
                for(int p : participants){
                    if(map.get(p)!=null)
                        shares.addAll(map.get(p));
                }
                for(int p: participants){
                    map.put(p, new HashSet<>(shares));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int goal = map.get(1).size();
        for(int p: map.keySet()){
            if(map.get(p).size() ==goal){
                result.add(p);
            }
        }
        Collections.sort(result);
        for(int v: result){
            bw.write(v+"\n");
        }
        bw.flush();
        bw.close();
    }
}
