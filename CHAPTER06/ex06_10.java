import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class ex06_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        Integer[] array=new Integer[N];
        // Collections 는 Integer
        for(int i=0;i<N;i++){
            array[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(array, Collections.reverseOrder());

        for(int i=0;i<N;i++){
            System.out.print(array[i]+" ");
        }
    }
}

// 3
// 15
// 27
// 21