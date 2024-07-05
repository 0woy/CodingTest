package BinarySearch;

import java.util.ArrayList;
import java.util.List;

class MedianFinder {
    private List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int idx = findIdx(num, 0,list.size()-1);
        list.add(idx,num);
    }
    public int findIdx(int num, int start, int end){
        if(start>end){
            return start;
        }
        int half = (start+end)/2;
        if(list.get(half)<num){
            return findIdx(num,half+1, end);
        }
        else{
            return  findIdx(num, start, half-1);
        }
    }

    public double findMedian() {
        int size = list.size();
        if(size%2==0){
            int idx1 = size/2;
            int idx2 = size/2-1;
            return (double)(list.get(idx1)+list.get(idx2))/2;

        }
        else{
            return list.get(size/2);
        }
    }

    public void printList(){
        for(int n: list){
            System.out.print(n+" ");
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class N_295 {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
