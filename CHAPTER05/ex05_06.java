import java.util.Arrays;

public class ex05_06 {
    public static void main(String[] args) {
        int INF=999999999;

        int[][] graph={
            {0,7,5},
            {7,0,INF},
            {5,INF,0}
        };

        for(int[] rows:graph)
            System.out.println(Arrays.toString(rows));
    }
}