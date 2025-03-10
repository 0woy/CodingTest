package Arrays_Hashing;

public class N_832 {
    /** My Solve
    public static int[][] flipAndInvertImage(int[][] image) {
        boolean isOdd = image.length % 2 == 1;
        for(int [] row : image){
            for(int i=0;i<row.length/2;i++){
                int tmp =row[image.length-i-1];
                row[image.length-i-1] = row[i]==1?0:1;
                row[i]=tmp==1?0:1;
            }

            if(isOdd){
                row[image.length/2]=row[image.length/2]==1?0:1;
            }
        }
        return image;
    }
     */
    public static int[][] flipAndInvertImage(int[][] image) {
        boolean isOdd = image.length % 2 == 1;
        for(int [] row : image){
            for(int i=0;i<row.length/2;i++){
                int tmp =row[image.length-i-1] ^ 1;
                row[image.length-i-1] = row[i]^1;
                row[i]=tmp;
            }

            if(isOdd){
                row[image.length/2]^=1;
            }
        }
        return image;
    }
    public static void main(String[] args) {
        int [][] image =new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        flipAndInvertImage(image);
    }
}
