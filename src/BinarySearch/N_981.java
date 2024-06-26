package BinarySearch;

import javax.management.ObjectName;
import javax.swing.text.TabableView;
import java.util.*;

class Value{
    String value;
    int time;

    public Value(){

    }
    public Value(String value, int time){
        this.value = value;
        this.time = time;
    }

    public String getValue(){
        return value;
    }
    public int getTime(){
        return time;
    }
    public void setValue(String value){
        this.value = value;
    }
    public void setTime(int time){
        this.time=time;
    }
}
class TimeMap{
    Map<String, List<Value>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public String binarySearch(List<Value> values, int target, int start, int end){
        Value result = new Value(null, Integer.MIN_VALUE);

        while(start<=end){
            int half = (start+end)/2;
            Value curValue =values.get(half);
            int curTime = curValue.getTime();

            if(curTime == target){
                return curValue.getValue();
            }

            if(curTime<target){
                if(curTime>result.getTime()){
                    result.setTime(curTime);
                    result.setValue(curValue.value);
                }
                start=half+1;
            }
            else{
                end = half-1;
            }
        }

        return result.getValue();
    }

    public void set(String key, String value, int timestamp) {
        Value valueSet = new Value(value,timestamp);
        List<Value> valueList = map.getOrDefault(key,null);

        if(valueList == null){
            valueList = new ArrayList<>();
        }

        valueList.add(valueSet);
        map.put(key, valueList);
    }

    public String get(String key, int timestamp) {
        List<Value> result = map.getOrDefault(key, null);
        if(result==null){
            System.out.println("");
            return null;
        }

        System.out.println( binarySearch(result,timestamp,0,result.size()-1));
        return null;
    }
}
public class N_981 {
    public static void main(String[] args) {

        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1);         // return "bar"
        timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        timeMap.get("foo", 5);         // return "bar2"
    }
}
