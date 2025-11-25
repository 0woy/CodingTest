class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        for(int [] size : sizes){
            for(int v: size) width = Math.max(v,width);
        }
        int height = 0;
        for(int [] size: sizes){
            int lower = (size[0]>size[1])?size[1]:size[0];
            height = Math.max(height, lower);
        }
        
        return width * height;
    }
}